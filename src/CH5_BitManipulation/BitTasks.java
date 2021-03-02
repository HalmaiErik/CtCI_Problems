package CH5_BitManipulation;

public class BitTasks {
    boolean getBit(int num, int i) {
        if ((num & (1 << i)) == 1) {
            return true;
        }
        else return false;
    }

    int setBit(int num, int i) {
        return num | (1 << i);
    }

    int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & i;
    }

    int updateBit(int num, int i, boolean bit) {
        int value = bit ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (value << i);
    }
}
