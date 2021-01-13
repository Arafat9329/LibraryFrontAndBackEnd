Feature:Get Book By Id

  @Abdu
  Scenario:
    Given student cant get book by id. use any id
#  make a request as a student, use any id
#  verify content type json
#  verify status code 403
#  verify reponse body:
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

