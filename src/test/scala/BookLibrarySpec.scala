import org.scalatest.FlatSpec

class BookLibrarySpec extends FlatSpec {
  it should "be possible to add a new book" in {
    val id = "1234567890"
    val title = "Domain-Driven Design"
    val book : Book = Book(id, title)
    assert(book.changes == new BookAddedToLibraryEvent(id, title) :: Nil)
  }
}
