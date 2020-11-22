package de.danoeh.jensklingenberg.util

import de.danoeh.antennapod.core.feed.Chapter

fun pparse(chapter: List<Chapter>,time:Int): Int? {
  return  chapter.find { it.start>time }?.start?.toInt()
}