int main (int arg){
	print arg;
    if ((5 != 10) || arg > 0){  /* Always True */
        return arg;
    }else {
        return -arg * 93;
    }
    return 0;
}