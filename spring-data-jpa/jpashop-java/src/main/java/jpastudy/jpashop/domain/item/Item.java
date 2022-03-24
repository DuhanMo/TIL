package jpastudy.jpashop.domain.item

import jpastudy.jpashop.domain.Category
import jpastudy.jpashop.exception.NotEnoughStockException
import lombok.Getter
import lombok.Setter
import java.util.ArrayList
import javax.persistence.*

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype") //싱글테이블 전략일 때 구분을 짓는 컬럼의 이름, -> 그 클래스들의 설정도 해줘야함
abstract class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private val id: Long? = null
    private val name: String? = null
    private val price = 0
    private var stockQuantity = 0

    @ManyToMany(mappedBy = "items")
    private val categories: List<Category> = ArrayList()

    //==비즈니스 로직==//
    fun addStock(quantity: Int) {
        stockQuantity += quantity
    }

    fun removeStock(quantity: Int) {
        val restStock = stockQuantity - quantity
        if (restStock < 0) {
            throw NotEnoughStockException("need more stock")
        }
        stockQuantity -= quantity
    }
}