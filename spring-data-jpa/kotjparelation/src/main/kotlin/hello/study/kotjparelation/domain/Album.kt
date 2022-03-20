package hello.study.kotjparelation.domain

import javax.persistence.Entity

@Entity
class Album(
    var artist: String
) : Item() {
}