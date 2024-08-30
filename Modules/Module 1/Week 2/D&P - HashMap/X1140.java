HashMap<String, String> reverseDictionary()
{
    HashMap<String, String> diccionario = new HashMap<>();

    // allocate a new HashMap
    

    // loop over all the words in the english one
    for (String english : dictionary.keySet()) {
        // now look up the spanish in dictionary
        String spanish = dictionary.get(english);

        // then add them to the diccionario
        diccionario.put(spanish, english);
    }

    return diccionario;
}
