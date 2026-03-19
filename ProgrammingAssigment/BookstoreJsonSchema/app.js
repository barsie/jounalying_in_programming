async function loadBooks() {
  try {
    const response = await fetch('bookstore.json');
    const data = await response.json();

    const bookList = document.getElementById('bookList');

    data.books.forEach(book => {
      // Main list item (Book)
      const bookItem = document.createElement('li');
      bookItem.className = 'book-item';

      // Book title
      const title = document.createElement('h3');
      title.className = 'book-title';
      title.textContent = `Book Title: ${book.title}`;

      // Nested list for details
      const detailsList = document.createElement('ul');
    //   detailsList.className = 'book-details';

      // Author
      const author = document.createElement('li');
      author.textContent = `Author: ${book.author.firstName} ${book.author.lastName}`;

      // Publication year
      const publication = document.createElement('li');
      publication.textContent = `Publication: ${book.publicationYear}`;

      // Publisher
      const publisher = document.createElement('li');
      publisher.textContent = `Publisher: ${book.details.publisher}`;

      // Page count
      const pages = document.createElement('li');
      pages.textContent = `Page Count: ${book.details.pageCount}`;

      // Availability
      const availability = document.createElement('li');
      availability.textContent = `Status: ${book.available ? 'Available' : 'Unavailable'}`;
      availability.className = book.available ? 'available' : 'unavailable';

      // Append all details
      detailsList.appendChild(author);
      detailsList.appendChild(publication);
      detailsList.appendChild(publisher);
      detailsList.appendChild(pages);
      detailsList.appendChild(availability);

      // Assemble book item
      bookItem.appendChild(title);
      bookItem.appendChild(detailsList);

      // Add to main list
      bookList.appendChild(bookItem);
    });

  } catch (error) {
    console.error('Error loading books:', error);
  }
}

loadBooks();