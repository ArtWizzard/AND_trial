package cz.matee.nemect.trial_03.ui.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class StaticGridCells {
    var columns: Int = 0

    constructor( pColumns: Int ) {
        columns = pColumns
    }
    constructor(parentWidth: Dp, contentWidth: Dp) {
        columns = ( parentWidth / contentWidth ).toInt()
        Log.d("Width measurement","ParentWidth: ${parentWidth} \tContentWidth: ${contentWidth} \tColumns: ${columns}")
    }

    fun get() : Int {
        return columns
    }
}

@Composable
fun StaticGrid(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    itemCount: Int,
    staticGridCells: StaticGridCells,
    content: @Composable() (Int) -> Unit
) {
    val columns = staticGridCells.get()

    Column(
        modifier = modifier
    ) {
        var rows = (itemCount / columns)    // pocet radku, ktere vzniknou (celociselne deleni)
        if (itemCount.mod(columns) > 0) {   // kvuli celoc. deleni pridame radek, kdyz se nevejdou itemy
            rows += 1
        }

        for (rowId in 0 until rows) {
            val firstIndex = rowId * columns            // startovni id itemu - podle radku

            Row {
                for (columnId in 0 until columns) {
                    // konkretni hodnota itemu - startovni pocet + pozice v radku
                    val index = firstIndex + columnId

                    // item
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(contentPadding)
                    ) {
                        if (index < itemCount) {
                            content(index)
                        }
                    }
                }
            }
        }
    }
}