public boolean addLikeASet(T anEntry){
    for(int i = 0; i < numberOfEntries; i++){
    	if(contents[i].equals(anEntry)){
            return false;
        } 
    }
    if(numberOfEntries < contents.length){
        contents[numberOfEntries] = anEntry;
    	numberOfEntries++;
        return true;
    }
    return false;
}
