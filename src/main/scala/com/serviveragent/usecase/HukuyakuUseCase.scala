package com.serviveragent.usecase

import java.time.LocalDateTime

import com.serviveragent.domain.Zolpidem

class HukuyakuUseCase() {
  private val zolpidem = com.serviveragent.domain.Zolpidem()

  def apply(name: String): Option[LocalDateTime] = {
    //todo: リファクタリングする
    name match {
      case _ if name == zolpidem.name =>
        Some(LocalDateTime.now().plusMinutes(zolpidem.TMax))
      case _ => None
    }
  }
}
