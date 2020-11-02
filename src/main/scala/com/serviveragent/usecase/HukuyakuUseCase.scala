package com.serviveragent.usecase

import java.time.LocalDateTime

import com.serviveragent.domain.Zolpidem

class HukuyakuUseCase() {
//  private val zolpidem = com.serviveragent.domain.Zolpidem()

  def apply(name: String): Option[LocalDateTime] = {
    name match {
      case _ if name == Zolpidem().name =>
        Some(LocalDateTime.now().plusMinutes(Zolpidem().TMax))
      case _ => None
    }
  }
}
