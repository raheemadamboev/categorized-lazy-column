package xyz.teamgravity.categorizedlazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.teamgravity.categorizedlazycolumn.ui.theme.CategorizedLazyColumnTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CategorizedLazyColumnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CategorizedLazyColumn(
                        categories = Data.data
                    )
                }
            }
        }
    }
}

data class CategoryModel(
    val name: String,
    val names: List<String>
)

@Composable
fun CardCategory(
    text: String
) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)
    )
}

@Composable
fun CardName(
    text: String
) {
    Text(
        text = text,
        fontSize = 14.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun CategorizedLazyColumn(
    categories: List<CategoryModel>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        categories.forEach { category ->
            stickyHeader(
                key = category.name
            ) {
                CardCategory(
                    text = category.name
                )
            }
            items(
                items = category.names,
                key = { it }
            ) { name ->
                CardName(
                    text = name
                )
            }
        }
    }
}