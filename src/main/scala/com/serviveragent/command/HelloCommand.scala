package com.serviveragent.command

import com.jagrosh.jdautilities.command.{Command, CommandEvent}
import com.typesafe.scalalogging.LazyLogging

class HelloCommand() extends Command with LazyLogging {
  this.name = "hello"
  this.help = "あいさつするだけ"

  override def execute(event: CommandEvent): Unit = {
    logger.info(s"from: ${event.getAuthor.getName}, command: hello")
    event.reply("こんにちは、" + event.getAuthor.getName + "さん！")
  }
}
