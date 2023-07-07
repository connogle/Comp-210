package assn07;

import java.util.*;


public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "password123";
    private Account[] _passwords;

    public PasswordManager() {
        _passwords = new Account[50];
    }


    // TODO: put
    @Override
    public void put(K key, V value) {
        if (_passwords[Math.abs(key.hashCode()) % 50] == null) {
            _passwords[Math.abs(key.hashCode()) % 50] = new Account(key, value);
        } else {
            Account temp = _passwords[Math.abs(key.hashCode()) % 50];
            while (temp!=null){
                if (temp.getWebsite().equals(key)) {
                    temp.setPassword(value);
                    break;
                }
                if (temp.getNext()==null){
                    temp.setNext(new Account(key, value));
                }
                temp = temp.getNext();
            }
        }
    }

    // TODO: get
    @Override
    public V get(K key) {
        Account hash = _passwords[Math.abs(key.hashCode()) % 50];
        if (hash==null){
            return null;
        } else {
            while (hash!=null){
                if (hash.getWebsite().equals(key)){
                    return (V) hash.getPassword();
                }
                hash=hash.getNext();
            }
        }
        return null;
    }

    // TODO: size
    @Override
    public int size() {
        int size = 0;
        for (Account key: _passwords) {
            while(key!=null){
                size++;
                key=key.getNext();
            }
        }
        return size;
    }

    // TODO: keySet
    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Account key: _passwords) {
            while(key!=null){
                keys.add((K) key.getWebsite());
                key=key.getNext();
            }
        }
        return keys;
    }

    // TODO: remove
    @Override
    public V remove(K key) {
        Account toRemove = _passwords[Math.abs(key.hashCode()) % 50];
        if (toRemove==null){

        } else {
            if (toRemove.getWebsite().equals(key)){
                if(toRemove.getNext()==null) {
                    _passwords[Math.abs(key.hashCode()) % 50] = null;
                } else {
                    _passwords[Math.abs(key.hashCode()) % 50] = toRemove.getNext();
                }
                return (V) toRemove.getPassword();
            } else {
                Account temp = toRemove.getNext();
                while (temp!=null){
                    if (temp.getWebsite().equals(key)){
                        if(temp.getNext()==null) {
                            toRemove.setNext(null);
                        } else {
                            toRemove.setNext(temp.getNext());
                        }
                        return (V) temp.getPassword();
                    }
                    toRemove=toRemove.getNext();
                    temp=temp.getNext();
                }
            }
        }
        return null;
    }

    // TODO: checkDuplicate
    @Override
    public List<K> checkDuplicate(V value) {
        List<K> dupes = new LinkedList() {
        };
        for (Account key: _passwords) {
            if (key!=null){
                if (key.getPassword().equals(value)){dupes.add((K) key.getWebsite());}
                if (key.getNext()!=null){
                    Account temp = key.getNext();
                    while(temp!=null){
                        if (temp.getPassword().equals(value)){dupes.add((K) temp.getWebsite());}
                        temp=temp.getNext();
                    }
                }
            }
        }
        return dupes;
    }

    // TODO: checkMasterPassword
    @Override
    public boolean checkMasterPassword(String enteredPassword) {
        if (enteredPassword.equals(MASTER_PASSWORD)){
            return true;
        } else {
            return false;
        }
    }

    /*
    Generates random password of input length
     */
    @Override
    public String generateRandomPassword(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /*
    Used for testing, do not change
     */
    public Account[] getPasswords() {
        return _passwords;
    }
}
