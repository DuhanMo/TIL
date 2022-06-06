package hello.study.kotjparelation.domain

import javax.persistence.Entity

@Entity
class Movie(
    var director: String,
    var actor: String
) : Item() {
}