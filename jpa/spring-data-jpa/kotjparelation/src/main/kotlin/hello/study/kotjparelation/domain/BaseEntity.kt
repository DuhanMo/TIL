package hello.study.kotjparelation.domain

import java.time.LocalDateTime
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity {
    open var createdDate: LocalDateTime = LocalDateTime.now()
    open var modifiedDate: LocalDateTime = LocalDateTime.now()
}