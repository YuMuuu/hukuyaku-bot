package com.serviveragent.domain

import scala.concurrent.duration.Duration

sealed trait SleepingPill {
  val name: String
  //最高血中濃度到達時間
  val TMax: Int
}
//ゾルピデム（Zolpidem）
case class Zolpidem() extends SleepingPill {
  val name: String = "ゾルピデム"
  val TMax: Int = 48
}
