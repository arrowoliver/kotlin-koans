package v_builders

import util.TODO
import util.doc39
import v_builders.data.getProducts
import v_builders.htmlLibrary.*

fun getTitleColor() = "#b9c9fe"
fun getCellColor(row: Int, column: Int) = if ((row + column) %2 == 0) "#dce4ff" else "#eff2ff"
fun getFontColor(row: Int, column: Int) = if ((row + column) %2 == 0) "#800000" else "#000000"

fun todoTask39(): Nothing = TODO(
    """
        Task 39.
        1) Fill the table with the proper values from products.
        2) Color the table like a chess board (using getTitleColor() and getCellColor() functions above).
        Pass a color as an argument to functions 'tr', 'td'.
        You can call the 'main' function in the 'htmlDemo.kt' to see the rendered table.
    """,
    documentation = doc39()
)

fun renderProductTable(): String {
    return html {
        table {
            tr (getTitleColor()){
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts()

            for((index, item) in products.withIndex()){
                tr {
                    td (getCellColor(index,1), getFontColor(index,1)){
                        text(item.description)
                    }
                    td (getCellColor(index,2), getFontColor(index,2)){
                        text(item.price)
                    }
                    td (getCellColor(index,3), getFontColor(index,3)){
                        text(item.popularity)
                    }
                }
            }
            /*var count = 0
            products.forEach {
                count++
                tr {
                    td (getCellColor(count,1)){
                        text(it.description)
                    }
                    td (getCellColor(count,2)){
                        text(it.price)
                    }
                    td (getCellColor(count,3)){
                        text(it.popularity)
                    }
                }
            }*/

        }
    }.toString()
}
