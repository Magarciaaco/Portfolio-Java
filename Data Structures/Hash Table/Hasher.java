/**
 * Hasher
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */

public class Hasher {
    public static void main(String[] args) {
        HashTable HashTable = new HashTable();

        HashTable.insert(10);
        HashTable.insert("Han Xolo");
        HashTable.insert("Hello\t" + 667);
        HashTable.insert("World");
        HashTable.insert("Han Solo");
        HashTable.insert(99843);
        HashTable.insert("Han Solo");
        HashTable.insert("Han Solo");
        HashTable.insert("Hello\t" + 667.98);

        HashTable.print();
    }
}