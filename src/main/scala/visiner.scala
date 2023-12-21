object Visiner {
  val alphabet = "йцукенгшщзхъфывапролджэячсмитьбю ёЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮЁ"
  val letter_number: Char => Int = (l: Char) =>

    alphabet.indexOf(l)

  val encrypt_letter: (Char, Char) => Char = (key_l: Char, l: Char) =>
    val enc_n = (letter_number(l) + letter_number(key_l)) % alphabet.length
    alphabet(enc_n)

  val decrypt_letter: (Char, Char) => Char = (key_l: Char, l: Char) =>
    var dec_n = letter_number(l) - letter_number(key_l)
    if (dec_n < 0) dec_n = alphabet.length + dec_n
    alphabet(dec_n)

  def encrypt(code_word: String, text: String): String = {
    (for
      i <- 0 until text.length
      key_i = i % code_word.length
    yield
      encrypt_letter(code_word(key_i), text(i))).mkString

  }

  def decrypt(code_word: String, text: String): String = {
    (for
      i <- 0 until text.length
      key_i = i % code_word.length
    yield
      decrypt_letter(code_word(key_i), text(i))).mkString
  }
}

object Main1 extends App {
  val key = "Ключ"
  val text = "Не ключи а утка"

  val enc_ = Visiner.encrypt(key, text)
  val dec_ = Visiner.decrypt(key, enc_)

  println(s"Зашифрованный: $enc_")
  println(s"Дешифрованный: $dec_")

}