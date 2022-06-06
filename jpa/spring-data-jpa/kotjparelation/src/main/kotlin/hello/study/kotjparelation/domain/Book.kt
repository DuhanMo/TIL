package hello.study.kotjparelation.domain

import javax.persistence.Entity

@Entity
class Book(
    var author: String,
    var isbn: String
) : Item() {
}
