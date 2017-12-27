package org.scriptonbasestar.tool.test

class HtmlReader {
	private fun readAsString(path: String): String {
		var input = javaClass.classLoader.getResourceAsStream("mailHtml/$path.html")
		return input.bufferedReader().use { it.readText() }
	}

	fun readDefault(code: String): String {
		val path = when(code){
			//가입
			"A0001"->{"member/join_success"}
			//탈퇴
			"A0002"->{"member/withdraw"}
//			임시비밀번호
			"A0003"->{"member/password_temp"}
			//비밀번호변경
			"A0004"->{"member/password_change"}
			//대출신청
			"B0001"->{"loan/loan_request"}
			//대출신청추가심사
			"B0002"->{"loan/loan_add"}
			//대출금지급
			"B0003"->{"loan/loan_send_money"}
			//대출금 상환
			"B0004"->{"loan/repay"}
			//대출금 상환 확인
			"B0005"->{"loan/result"}
			//투자상품 시작
			"C0002"->{"product/product"}
//			"C0002"->{"invest/funding_start"}
			//투자자 투자완료
			"C0005"->{"invest/invest_success"}
			//투자자 투자취소
			"C0006"->{"invest/invest_cancel"}
			//투자상품 수익금 지급
			"C0007"->{"invest/repay"}
			//투자상품 중도상환
			"C0008"->{"invest/m_complete"}
			//추심금 지급
			"C0012"->{"invest/collect_repay"}
			//예치금 출금
			"D0001"->{"member/balance_withdraw"}
			else->{ throw Exception("예상치 못한 오류 발생. 존재하지 않는 코드 요청. $code")}
		}
		return readAsString(path)
	}
}
