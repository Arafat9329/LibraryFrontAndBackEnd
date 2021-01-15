Feature: Get Book By Id

  @Abdu @api
  Scenario: student cant get book by id. use any id
    Given make a request as a student
    Then verify content type json
    And verify status code 403
    And verify response body in get book by ID

 #{
#error": "Unauthorized Access",
#"details": "/get_book_by_id/@id:[0-9]+"
#}


#  @Arpat
#  Scenario:
#    Given librarian can get book by id.
#  make a request as a student, use a valid id (to make sure that you always use valid id, you may have to create  new book)
#  verify content type json
#  verify status code 202
#  based on the sample below, verify that response contains all following field with with values not empty or null
#  |"id":| "200",|
#  |"name":| "Herb O'Kon PhD"|
#  "isbn": "387750360824",
#  "year": "2006",
#  "author": "Malvina Roden",
#  "book_category_id": "3",
#  "description": "Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.",
#  "added_date": "2019-03-28 00:00:00"
#


  #{
#error": "Unauthorized Access",
#"details": "/get_book_by_id/@id:[0-9]+"
#}


  @Arpat @api
  Scenario:librarian can get book by id 200.
    Given  make a request as a librarian, use a valid id 200
    Then arp.verify content type json
    And arp.verify status code 200
    And based on the sample below, verify that response contains all following field with with values not empty or null
      | id               | 200                                                                                             |
      | name             | Alectura lathami                                                                                |
      | isbn             | 387750360824                                                                                    |
      | year             | 2006                                                                                            |
      | author           | Malvina Roden                                                                                   |
      | book_category_id | 3                                                                                               |
      | description      | Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris. Si si si |
      | added_date       | 2019-03-28 00:00:00                                                                             |

