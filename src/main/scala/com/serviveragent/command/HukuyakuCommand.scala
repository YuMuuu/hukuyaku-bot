package com.serviveragent.command

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.jagrosh.jdautilities.command.{Command, CommandEvent}
import com.serviveragent.usecase.HukuyakuUseCase

class HukuyakuCommand(hukuyakuUseCase: HukuyakuUseCase) extends Command {
  this.name = "ふくやく"
  this.help = "no description"

  override def execute(event: CommandEvent): Unit = {
    val pillName = event.getArgs

    val maybeLocalDateTime = hukuyakuUseCase(pillName)

    val message = maybeLocalDateTime match {
      case Some(ldt: LocalDateTime) =>
        s"""おくすりのめてえらいね！
           |最高血中濃度到達時間は ${toStr(ldt, "dd日HH時mm分")} だよ！
           |""".stripMargin
      case None => s"みつけられないおくすりだった(泣"
    }

    event.reply(message)
  }

  private def toStr(localDateTime: LocalDateTime, format: String): String = {
    val dateTimeFormatter = DateTimeFormatter.ofPattern(format)
    localDateTime.format(dateTimeFormatter)
  }
}
