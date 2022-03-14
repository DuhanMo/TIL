package hello.study.kotjparelation.domain

import javax.persistence.*

@Entity
class Team(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null,
    var name: String,
    @OneToMany
    var members: List<Member>?=null
) {
    override fun toString(): String {
        return "Team(id=$id, name='$name', members=$members)"
    }
}