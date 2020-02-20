public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        Deque<Character> res = new LinkedListDeque<>();
        for(int i = 0; i < word.length(); i++){
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word){
        return isPalindrome(wordToDeque(word));
    }
    private boolean isPalindrome(Deque<Character> wordToDeque) {
        if(wordToDeque.size() == 0 || wordToDeque.size() == 1) return true;
        Character tmp1 = wordToDeque.removeFirst() ;
        Character tmp2 = wordToDeque.removeLast() ;
        return (tmp1 == tmp2 && isPalindrome(wordToDeque));
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(wordToDeque(word),cc);
    }
    private boolean isPalindrome(Deque<Character> wordToDeque,CharacterComparator cc){
        if(wordToDeque.size() == 0 || wordToDeque.size() == 1) return true;
        Character tmp1 = wordToDeque.removeFirst() ;
        Character tmp2 = wordToDeque.removeLast() ;
        return (cc.equalChars(tmp1,tmp2) && isPalindrome(wordToDeque, cc));
    }
}
