public int lucasNumber(int n)
{
    switch(n){
    case 0:
    	return 2;
    case 1:
    	return 1;
    default:
    	return lucasNumber(n-1) + lucasNumber(n-2);
    }
}
