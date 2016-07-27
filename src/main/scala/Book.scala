
object Book {
  def apply(id: String, title: String) = {
    val book = new Book()
    book.handle(new BookAddedToLibraryEvent(id, title))
    book
  }
}

class Book {
  var id = ""
  var title = ""
  var changes: List[Event] = Nil

  def handle(event: Event): Unit = {
    changes = event :: changes
    event match {
      case BookAddedToLibraryEvent(bookId, bookTitle) => {
        id = bookId
        title = bookTitle
      }
    }
  }

  def markChangesAsCommited() = {
    changes = Nil
  }
}

case class BookAddedToLibraryEvent(id: String, title: String) extends Event
