package com.rockymadden.stringmetric

object Tokenize {
	trait Tokenizer[A] {
		def tokenize(a: A): Option[Array[A]]
	}


	trait StringTokenizer extends Tokenizer[Array[Char]] {
		def tokenize(a: String): Option[Array[String]]
	}


	object StringTokenizer {
		val NGram = tokenize.NGramTokenizer

		def tokenizeWithNGram(n: Int)(charArray: Array[Char]) = NGram(n).tokenize(charArray)
	}
}
