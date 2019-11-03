public interface Sound {        //abstract függvények és konstansok lehetnek benne

    String BASIC = "----";      //implicit konstans(final) lesz

    void saySomething();     //minden függvény amit definiálunk benne, alapból(implicit) abstract és public lesz

    String horn();
}