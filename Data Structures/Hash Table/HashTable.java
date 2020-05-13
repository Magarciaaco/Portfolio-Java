/**
 * HashTable
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */

public class HashTable {
    private Object[] Table;
    private final int Size = 100;

    HashTable() {
        this.Table = new Object[this.Size];
    }

    void insert(Object E) {
        String str = E.toString();

        if ( Empty(Key(str.toCharArray()))) Handle(str);
            else Collide(str);

    }

    private void Handle(String O) {
        this.Table[Key(O.toCharArray())] = O;
    }

    private Boolean Empty(int Key) {
        return this.Table[Key] == null;
    }

    private void Collide(String str) {
        if( str == this.Table[Key(str.toCharArray())] ) return;

        int i = 0;
        while( this.Table[Key(str.toCharArray()) + i] == str || !Empty(Key(str.toCharArray())) ) i++;

        this.Table[Key(str.toCharArray() ) + i] = str;
    }

    private int Key(char[] E) {
        int n = 0;

        for (char x : E) {
            n = (int) x + n;
        }

        return n % this.Table.length;
    }


    Object[] getTable() {
        return this.Table;
    }

    void print() {
        for(Object Obj :  this.Table) {
            if (Obj != null) System.out.println(Obj);
        }
    }
}