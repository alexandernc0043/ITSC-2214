void testFour()
{
    // write your tests here
    assertNotNull(futureCEO.getName());
    futureCEO.setName("Bob");
    assertEquals(futureCEO.getName(), "Bob");
}
