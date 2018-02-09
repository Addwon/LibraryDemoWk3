#Library Demo 

Note: In order to pass the challenge you MUST create a site that runs!
If it doesn't run you don't pass the challenge even if everything else is perfect.
That means you should TEST your site on a different computer using IntelliJ.
You must also push your site to GitHub and submit it to Canvas BEFORE 3:00 PM.
The link disappears after that time and you will not have the opportunity to submit it to Canvas.
***
You are going to develop a basic library application for the JBC Library. 
In the library, there is only one copy of each book. You will create the following: 
- A main page for the library's website. It will have a navigation bar with the following items: 
- Home (only displays when not on the home page) 
- List books 
- Add a book 
- Borrow a book 
- Return a book
The navigation bar should show on all pages, highlighting the page that the user is currently on. 
 
###Listing books:
Show a list of all books, and indicate whether they have been borrowed or not.  
 
###Adding books: 
To add a book, you must enter the following information about it: 
- Title (required)
- Author (required)
- Year of Publication (required)
- ISBN Number (optional)
- Image (optional) 

You must include optional fields in this project. The field is optional because a user may choose not to enter data into it. 
 
###Borrowing books
Show a list of available books, and allow a user to borrow the book. Once the user has borrowed the book, show a message at the top of the page to indicate that the book has been borrowed. 
 
###Returning books
Show a list of borrowed books, and allow a user to return the book. Once the user has returned the book, show a message at the top of the page to indicate that the book has been returned. 
 
#####Use Bootstrap 4 for your website. 

###DONE ALREADY (Bonus)? - 2 points for each item
- Display a default image of a book if a url has not been given
- Add a timestamp which automatically updates the record of when a book was last borrowed. 
- Create a historic record of borrowed books 
- Add a link to navigation called 'Popular books', and use this to show: 
       A list of books ordered (in descending order) by how many times each book has been ordered. 
       Clicking on an item in this list should allow you to see the borrowing history of that particular book. 
-  Create a Cloudinary account and upload your images.  - 10 extra points
- Deploy your application to Heroku. - 10 extra points
 
 
 
 
 