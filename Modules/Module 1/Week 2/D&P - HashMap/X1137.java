String getSpanish(String english)
{
    String spanish = dictionary.get(english);
    if (spanish != null)
        return spanish;
    else
        return "?";
}
