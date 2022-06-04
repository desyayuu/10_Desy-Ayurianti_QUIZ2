import java.util.Scanner;
class Node_10{
    Pesanan psn;
    Pembeli pmb;
    Node_10 prev, next;

    Node_10(Node_10 prev, Pembeli pmb, Node_10 next ){
        this.prev=prev;
        this.pmb=pmb;
        this.next=next;
    }
    Node_10(Node_10 prev, Pesanan psn, Node_10 next ){
        this.prev=prev;
        this.psn=psn;
        this.next=next;
    }


}
class Pembeli{
    int noAntri;
    String namaPembeli, NoHp;

    Pembeli(int n, String b, String c){
        this.noAntri=n;
        this.namaPembeli=b;
        this.NoHp=c;
    }

}
class Pesanan{
    int kodePesanan;
    String namaPeanan;
    int harga;

    Pesanan(int a, String b, int d){
        this.kodePesanan=a;
        this.namaPeanan=b;
        this.harga=d;
    }
}
class DoubleLinkedList{
    Node_10 head;
    int size;

    DoubleLinkedList(){
        head=null;
        size=0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(Pembeli pmb){
        if (isEmpty()) {
            head = new Node_10(null, pmb, null);
        } else {
            Node_10 newNode = new Node_10(null, pmb, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Pembeli pem){
        if (isEmpty()) {
            addFirst(pem);
        } else {
            Node_10 current = head;
            while(current.next != null){
                current = current.next;
            }
            Node_10 newNode = new Node_10(current, pem, null);
            current.next = newNode;
            size++;
        }
    }
    public void addFirstPesanan(Pesanan psn){
        if (isEmpty()) {
            head = new Node_10(null, psn, null);
        } else {
            Node_10 newNode = new Node_10(null, psn, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLastPesanan(Pesanan psn){
        if (isEmpty()) {
            addFirstPesanan(psn);
        } else {
            Node_10 current = head;
            while(current.next != null){
                current = current.next;
            }
            Node_10 newNode = new Node_10(current, psn, null);
            current.next = newNode;
            size++;
        }
    }
    public void print(){
        if(!isEmpty()){
            Node_10 tmp = head;
            while (tmp!=null){
                System.out.println("|"+ tmp.pmb.noAntri +"\t|"+ tmp.pmb.namaPembeli+"\t|" + tmp.pmb.NoHp);
                tmp=tmp.next;
            }
        }else{
            System.out.println("Linked Lists kosong");
        }
    }
    public void printPesanan(){
        if(!isEmpty()){
            Node_10 tmp = head;
            while (tmp!=null){
                System.out.println("|"+ tmp.psn.kodePesanan +"\t|"+ tmp.psn.namaPeanan+"\t|" + tmp.psn.harga);
                tmp=tmp.next;
            }
        }else{
            System.out.println("Linked Lists kosong");
        }
    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus");
        } else if (size == 1) {
            removeLast();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node_10 current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        System.out.println("Nomor Antrian : " + current.psn.kodePesanan);
        System.out.println("Nama Customer : " + current.psn.namaPeanan);
        System.out.println("Nama Customer : " + current.psn.harga);
        current.next = null;
        size--;
    }

    public void hitungPendapatan() {
        int total = 0;
        Node_10 current = head;
        while (current != null) {
            total = total + current.psn.harga;
            current = current.next;
        }
        System.out.println("\nTotal Pendapatan = " + total);
    }
}




public class Kuis_1 {
    public static void menu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Cetak Antrian");
        System.out.println("3. Hapus Antrian");
        System.out.println("4. Laporan Pengurutan Pesanan by nama");
        System.out.println("5. Hitung total Pendapatan");
        System.out.println("6. Keluar");
        System.out.println("-------------------");
    }
    public static void identitas() {
        System.out.println("===========QUIZ 2 PRATIKUM ASD TI -1G============");
        System.out.println("dibuat oleh: Desy Ayurianti");
        System.out.println("NIM: 2141720119");
        System.out.println("Absen: 10");
        System.out.println("===================================================");
        System.out.println("Sistem Antrian Royal Delish");
    }
    public static void main(String[] args) throws Exception {
        DoubleLinkedList dll = new DoubleLinkedList();
        Scanner sc = new Scanner(System.in);
        identitas();
        int pilih, id, index;
        String nama, hp;
        do {
            menu();
            System.out.print("Pilih (1-6): ");
            pilih = sc.nextInt();
            sc.nextLine();
            switch (pilih) {
                case 1:
                    System.out.println("------------------------------");
                    System.out.println("Masukkan Data Pembeli");
                    System.out.println("------------------------------");
                    System.out.print("No Antrian: ");
                    id = sc.nextInt();
                    System.out.print("Nama Customer: ");
                    sc.nextLine();
                    nama = sc.nextLine();
                    System.out.print("Nomor Hp: ");
                    hp = sc.nextLine();
                    Pembeli pb = new Pembeli(id, nama, hp);
                    dll.addLast(pb);
                    break;
                case 2:
                    System.out.println();
                    System.out.println("------------------------------");
                    System.out.println("Daftar Antrian Rest Royal Delish");
                    System.out.println("------------------------------");
                    dll.print();
                    break;
                case 3:
                    dll.removeFirst();
                    System.out.println("Trasnsaksi input pesanan");
                    System.out.print("Nomor Pesanan: ");
                    int noPesanan = sc.nextInt();
                    System.out.print("pesanan: ");
                    String namaPesanan =sc.next();
                    System.out.print("harga: ");
                    int harga= sc.nextInt();
                    Pesanan psn = new Pesanan(noPesanan, namaPesanan,harga);
                    dll.addLastPesanan(psn);
                    System.out.println("------------------------------");
                    System.out.println("Daftar Antrian Rest Royal Delish");
                    System.out.println("------------------------------");
                    dll.printPesanan();
                    break;
                case 4:
                    dll.removeFirst();
                    break;
                case 5:
                    dll.hitungPendapatan();
                case 6:
                    break;
            }
        } while (pilih == 1 || pilih==2 || pilih ==3 | pilih==4 || pilih ==5 );
    }
}

