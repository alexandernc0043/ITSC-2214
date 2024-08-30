void addWords(String[] english, String[] spanish)
{
    for (int i = 0; i < english.length; i++)
        dictionary.put(english[i],spanish[i]);
}
