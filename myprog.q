mutable int main(int arg)
{
    if (arg == 1){
        markSweep();
    }

    if (arg == 2){
        refCount();
    }

    if (arg == 3){
        expMarkSweep();
    }

    if (arg == 4){
        noExpRefCount();
    }
    
    return 0;
}

mutable int markSweep(){

    mutable int listSize = 16; /* eight byte heap 408 - 384 */ 
    Ref root = nil. nil;
    mutable Ref temp = root;

    while (listSize > 0) { /*Sweep*/
        setRight(temp,  nil . nil);
        temp = (Ref)right(temp);
        listSize = listSize - 1;
    }
    return 0;

}

mutable int refCount() {
    mutable int listSize = 888;
    while (listSize > 0) {
        Ref a = 1 . nil;
        Ref b = 2 . nil;
        setRight(a, b);
        setRight(b, a);

        listSize = listSize - 1;
    }
    return 0;
}

mutable int expMarkSweep(){
    mutable int listSize = 16; /* eight byte heap 408 - 384 */ 
    Ref root = nil. nil;
    mutable Ref temp = root;

    while (listSize > 0) { /*Sweep*/
        setRight(temp,  nil . nil);
        Ref prev = temp;
        temp = (Ref)right(temp);
        free(prev);
        listSize = listSize - 1;
    }
    return 0;
}

mutable int noExpRefCount(){
    mutable int listSize = 10;
    while (listSize > 0) {
        Ref a = 1 . nil;
        Ref b = 2 . nil;
        setRight(a, b);
        setRight(b, a);

        listSize = listSize - 1;
    }
    return 0;
}


