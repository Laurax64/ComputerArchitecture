package com.example.computerarchitecture.ui.screens.caching

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays the caching screen.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun CachingScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.caching), navigateBack = navigateBack
            )
        },
    ) { paddingValues ->
        CachingScreen(
            Modifier
                .padding(paddingValues)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

/**
 * Displays the caching screen.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun CachingScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState()), Arrangement.spacedBy(8.dp)) {
        ReduceCacheMisses(Modifier.fillMaxWidth())
        ReduceHitTime(Modifier.fillMaxWidth())
        IncreaseMemoryBandwidth(Modifier.fillMaxWidth())
        ReduceMissPenalty(Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about reducing cache misses.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun ReduceCacheMisses(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.reduce_cache_misses),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                LargerCacheBlocks(Modifier.fillMaxWidth())
                LargerCaches(Modifier.fillMaxWidth())
                HigherAssociativity(Modifier.fillMaxWidth())
            }
        }
    }
}

/**
 * Displays a card with information about larger cache blocks to reduce cache misses.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun LargerCacheBlocks(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(stringResource(R.string.larger_cache_blocks), fontWeight = FontWeight.Bold)
            if (expanded) {
                Column {
                    Text(
                        stringResource(R.string.disadvantages),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(stringResource(R.string.larger_cache_blocks_disadvantages))
                }
            }
        }
    }
}


/**
 * Displays a card with information about larger caches to reduce cache misses.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun LargerCaches(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(stringResource(R.string.larger_caches), fontWeight = FontWeight.Bold)
            if (expanded) {
                Column {
                    Text(
                        stringResource(R.string.disadvantages),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(stringResource(R.string.larger_caches_disadvantages))
                }
            }
        }
    }
}

/**
 * Displays a card with information about higher associativity to reduce cache misses.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun HigherAssociativity(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(stringResource(R.string.higher_associativity), fontWeight = FontWeight.Bold)
            if (expanded) {
                Column {
                    Text(
                        stringResource(R.string.disadvantages),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(stringResource(R.string.higher_associativity_disadvantages))
                }
            }
        }
    }
}

/**
 * Displays a card with information about reducing hit time.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun ReduceHitTime(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.reduce_hit_time),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                SmallAndSimpleCaches(Modifier.fillMaxWidth())
                NoAddressTranslationOnCacheAccess(Modifier.fillMaxWidth())
            }
        }
    }
}

/**
 * Displays a card with information about small and simple caches to reduce hit time.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun SmallAndSimpleCaches(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(stringResource(R.string.small_and_simple_caches), fontWeight = FontWeight.Bold)
            if (expanded) {

                Text(stringResource(R.string.small_and_simple_caches_advantages))
            }
        }
    }
}

/**
 * Displays a card with information about no address translation on cache access to reduce hit time.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun NoAddressTranslationOnCacheAccess(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.no_address_translation_on_cache_access),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.no_address_translation_on_cache_access_advantages))
            }
        }
    }
}

@Composable
private fun IncreaseMemoryBandwidth(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.increase_memory_bandwidth),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                MultibankedCaches(Modifier.fillMaxWidth())
                PipelinedCacheAccess(Modifier.fillMaxWidth())
            }
        }
    }
}

/**
 * Displays a card with information about multibanked caches to increase memory bandwidth.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun MultibankedCaches(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.multibanked_caches),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.multibanked_caches_description))
            }
        }
    }

}

/**
 * Displays a card with information about pipelined cache access to increase memory bandwidth.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
fun PipelinedCacheAccess(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.pipelined_cache_access),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.pipelined_cache_access_description))
            }
        }
    }
}

/**
 * Displays a card with information about reducing miss penalty.
 *
 * @param modifier The modifier for the layout.

 */
@Composable
private fun ReduceMissPenalty(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.reduce_miss_penalty),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                NonblockingCaches(Modifier.fillMaxWidth())
                GroupingOfWriteBuffers(Modifier.fillMaxWidth())
                MulitpleCacheLevels(Modifier.fillMaxWidth())
                CriticalWordFirstEarlyRestart(Modifier.fillMaxWidth())
                PrioritizationOfReadOverWriteAccesses(Modifier.fillMaxWidth())
                Prefetching(Modifier.fillMaxWidth())
            }
        }
    }
}

/**
 * Displays a card with information about nonblocking caches to reduce miss penalty.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun NonblockingCaches(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.nonblocking_caches),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.nonblocking_caches_description))
            }
        }
    }
}

/**
 * Displays a card with information about grouping of write buffers to reduce miss penalty.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun GroupingOfWriteBuffers(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.grouping_of_write_buffers),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.grouping_of_write_buffers_description))
            }
        }
    }
}

/**
 * Displays a card with information about multiple cache levels to reduce miss penalty.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun MulitpleCacheLevels(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.multiple_cache_levels),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.multiple_cache_levels_description))
            }
        }
    }
}

/**
 * Displays a card with information about critical word first early restart to reduce miss penalty.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun CriticalWordFirstEarlyRestart(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.critical_word_first_early_restart),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.critical_word_first_early_restart_description))
            }
        }
    }
}

/**
 * Displays a card with information about prioritization of read over write accesses to reduce miss penalty.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun PrioritizationOfReadOverWriteAccesses(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.prioritization_of_read_over_write_accesses),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.prioritization_of_read_over_write_accesses_description))
            }
        }
    }
}

/**
 * Displays a card with information about prefetching to reduce miss penalty.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun Prefetching(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.prefetching),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.prefetching_description))
            }
        }
    }
}

/**
 * Displays previews for the caching screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
private fun CachingScreenPreview() {
    ComputerArchitectureTheme {
        CachingScreen(
            navigateBack = {},
        )
    }
}
