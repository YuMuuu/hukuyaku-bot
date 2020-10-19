package com.serviveragent.command

import com.jagrosh.jdautilities.command.{Command, CommandEvent}

class HelloCommand() extends Command {
  this.name = "hello"
  this.help = "あいさつするだけ"

  override def execute(event: CommandEvent): Unit =
    event.reply("こんにちは、" + event.getAuthor.getName + "さん！")
}
