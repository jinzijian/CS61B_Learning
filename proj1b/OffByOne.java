public class OffByOne implements CharacterComparator  {
    @Override
    public boolean equalChars(char x, char y) {
        int tmp = Math.abs(x - y);
        return tmp == 1;
    }
}
