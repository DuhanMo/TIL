package hello.study.kotjparelation.domain

import java.time.LocalDateTime
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity {
    var createdDate: LocalDateTime = LocalDateTime.now()
    var modifiedDate: LocalDateTime = LocalDateTime.now()
}