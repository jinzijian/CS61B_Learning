public class OffByN implements CharacterComparator {
    int number;
    public OffByN(int N){
        number = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int tmp = Math.abs(x - y);
        return tmp == number;
    }
}
