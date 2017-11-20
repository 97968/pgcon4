import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // ���C��������64�o�C�g�i����6�r�b�g���g�p�j
    static byte[] memory = new byte[64];
    static byte[] register = new byte[6];
    static boolean zf;
    static boolean cf;

    // ���͂�1�s�ڂ�����ǂݍ��݃��C�������������������āA���C���������̏�Ԃ��o�͂���v���O�����ł��B
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 1�s�ڃ��C��������
        String line = in.readLine();
        for (int i = 0; i < line.length(); i++) {
            byte val = base64Decode(line.charAt(i));
            memory[i] = val;
        }

        // TODO:2�s�ڈȍ~��ǂݍ��݁A�X�N���v�g�����s����
        solve(in);

        // ���C���������̏�Ԃ��o�͂���
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < memory.length; i++) {
            sb.append(base64Encode(memory[i]));
        }
        System.out.println(sb.toString());
    }

    // ******************************************************************************

    // BASE64�e�[�u��
    static final String base64_TBL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    // BASE64�G���R�[�h�F0-63�͈̔͊O�̃`�F�b�N�����Ă��܂���B
    static char base64Encode(int v) {
        return base64_TBL.charAt(v);
    }

    // BASE64�f�R�[�h�F�s���ȕ����̃`�F�b�N�����Ă��܂��񂪁A���̓f�[�^�̓G���[���Ȃ����Ƃ��ۏ؂���܂��B
    static byte base64Decode(char c) {
        return (byte) base64_TBL.indexOf(c);
    }

    static void solve(BufferedReader in) throws IOException {
        String[] orders;
        ;
        int line = Integer.parseInt(in.readLine());
        orders = new String[line];
        for (int i = 0; i < line; i++) {
            orders[i] = in.readLine();
        }
        int next = 1;
        for (int i = 0; i < line; i += next) {
            next = 1;
            if (orders[i].startsWith(";")) {
                continue;
            }
            String[] order = orders[i].split(" ");
            switch (order[0]) {
            case "NOP":
                continue;
            case "HLT":
                return;
            case "MOV":
                mov(order[1]);
                break;
            case "INC":
                calc(order[1].charAt(0), 1);
                break;
            case "DEC":
                calc(order[1].charAt(0), -1);
                break;
            case "ADD":
                calc(order[1].charAt(0), register[order[1].charAt(2) - 'A']);
                break;
            case "SUB":
                calc(order[1].charAt(0), -register[order[1].charAt(2) - 'A']);
                break;
            case "CMP":
                cmp(order[1]);
                break;
            case "JMP":
                next = jmp(order[1], true);
                break;
            case "JPZ":
                next = jmp(order[1], zf);
                break;
            case "JNZ":
                next = jmp(order[1], !zf);
                break;
            case "JPC":
                next = jmp(order[1], cf);
                break;
            case "JNC":
                next = jmp(order[1], !cf);
                break;
            }
        }
    }

    static void mov(String args) {
        if (args.matches("[ABCDEF],[0-9]+")) {
            char reg = args.charAt(0);
            int num = Integer.parseInt(args.split(",")[1]);
            register[reg - 'A'] = (byte) num;
        } else if (args.matches("[ABCDEF],[ABCDEF]")) {
            char reg1 = args.charAt(0);
            char reg2 = args.charAt(2);
            register[reg1 - 'A'] = register[reg2 - 'A'];
        } else if (args.matches("\\([ABCDEF]\\),[ABCDEF]")) {
            char reg1 = args.charAt(1);
            char reg2 = args.charAt(4);
            memory[register[reg1 - 'A']] = register[reg2 - 'A'];
        } else if (args.matches("[ABCDEF],\\([ABCDEF]\\)")) {
            char reg1 = args.charAt(0);
            char reg2 = args.charAt(3);
            register[reg1 - 'A'] = memory[register[reg2 - 'A']];
        }
    }

    static void calc(char reg, int value) {
        cf = (register[reg - 'A'] + value) > 63 || (register[reg - 'A'] + value) < 0;
        register[reg - 'A'] = (byte) ((register[reg - 'A'] + value) & 0x3f);
        zf = register[reg - 'A'] == 0;
    }

    static void cmp(String args) {
        char reg1 = args.charAt(0);
        char reg2 = args.charAt(2);
        zf = register[reg1 - 'A'] == register[reg2 - 'A'];
        cf = register[reg1 - 'A'] < register[reg2 - 'A'];

    }

    static int jmp(String args, boolean flag) {
        if (flag) {
            int jump = 0;
            boolean plus = args.charAt(1) == '+' ? true : false;
            jump = Integer.parseInt(args.substring(2));
            return plus ? jump : -jump;
        }
        return 1;
    }
}