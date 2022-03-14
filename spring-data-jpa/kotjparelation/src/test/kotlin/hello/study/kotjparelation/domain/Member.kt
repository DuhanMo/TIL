package hello.study.kotjparelation.domain

import javax.persistence.*

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null,
    var name: String,
    @ManyToOne
    var team: Team
) {
//    override fun toString(): String {
//        return "Member(id=$id, name='$name', team=$team)"
//    }
}