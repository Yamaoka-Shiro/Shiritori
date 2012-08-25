package jp.co.est_inc.android.shiritori;

import java.util.ArrayList;
import java.util.Random;

public class ImageData {
	// 回答ボタンの数
	private static final int NUM_ANSWER_BUTTON = 3;

	// 全画像のリスト
	private ArrayList<ImageInfo> imageDataList;

	// メイン画像のIndex
	private int idxMainImage;

	// 正解のボタン番号
	private int numCorrectButton;

	public int GetNumCorrectButton() {
		return numCorrectButton;
	}

	// 回答ボタンのIndex
	private ArrayList<Integer> idxAnswerImages;

	public ImageData() {
		imageDataList = new ArrayList<ImageInfo>();

		// 全画像セット
		CreateImageDataList();

		// 最初のメイン画像を決定する
		SetFirstMainImage();

		// 回答ボタンの画像を決定する
		idxAnswerImages = new ArrayList<Integer>();
		SetSelectImages();
	}

	// メイン画像の resId を返す
	public int GetMainImageResId() {
		return imageDataList.get(idxMainImage).GetResID();
	}

	// メイン画像を選択したボタンの画像に変更する
	public void SetMainImageByButton(int numButton) {
		idxMainImage = idxAnswerImages.get(numButton).intValue();
	}

	// 回答ボタン(N)の resId を返す
	public int GetAnswerButtonResId(int n) {
		return imageDataList.get(idxAnswerImages.get(n).intValue()).GetResID();
	}

	// 全画像をリストにセット
	private void CreateImageDataList() {
		// あかちゃん
		ImageInfo imageInfoAkachan = new ImageInfo(R.drawable.akachan, "あ", "ん");
		imageDataList.add(imageInfoAkachan);
		// あめ
		ImageInfo imageInfoAme = new ImageInfo(R.drawable.ame, "あ", "め");
		imageDataList.add(imageInfoAme);
		// あり
		ImageInfo imageInfoAri = new ImageInfo(R.drawable.ari, "あ", "り");
		imageDataList.add(imageInfoAri);
		// いか
		ImageInfo imageInfoIka = new ImageInfo(R.drawable.ika, "い", "か");
		imageDataList.add(imageInfoIka);
		// いちご
		ImageInfo imageInfoIchigo = new ImageInfo(R.drawable.ichigo, "い", "ご");
		imageDataList.add(imageInfoIchigo);
		// いぬ
		ImageInfo imageInfoInu = new ImageInfo(R.drawable.inu, "い", "ぬ");
		imageDataList.add(imageInfoInu);
		// うさぎ
		ImageInfo imageInfoUsagi = new ImageInfo(R.drawable.usagi, "う", "ぎ");
		imageDataList.add(imageInfoUsagi);
		// うちわ
		ImageInfo imageInfoUchiwa = new ImageInfo(R.drawable.uchiwa, "う", "わ");
		imageDataList.add(imageInfoUchiwa);
		// えんぴつ
		ImageInfo imageInfoEnpitsu = new ImageInfo(R.drawable.enpitsu, "え", "つ");
		imageDataList.add(imageInfoEnpitsu);
		// おかね
		ImageInfo imageInfoOkane = new ImageInfo(R.drawable.okane, "お", "ね");
		imageDataList.add(imageInfoOkane);
		// おに
		ImageInfo imageInfoOni = new ImageInfo(R.drawable.oni, "お", "に");
		imageDataList.add(imageInfoOni);
		// おにぎり
		ImageInfo imageInfoOnigiri = new ImageInfo(R.drawable.onigiri, "お", "り");
		imageDataList.add(imageInfoOnigiri);
		// カエル
		ImageInfo imageInfoKaeru = new ImageInfo(R.drawable.kaeru, "か", "る");
		imageDataList.add(imageInfoKaeru);
		// かきごおり
		ImageInfo imageInfoKakigoori = new ImageInfo(R.drawable.kakigoori, "か",
				"り");
		imageDataList.add(imageInfoKakigoori);
		// かすてら
		ImageInfo imageInfoKasutera = new ImageInfo(R.drawable.kasutera, "か",
				"ら");
		imageDataList.add(imageInfoKasutera);
		// かめ
		ImageInfo imageInfoKame = new ImageInfo(R.drawable.kame, "か", "め");
		imageDataList.add(imageInfoKame);
		// かめら
		ImageInfo imageInfoKamera = new ImageInfo(R.drawable.kamera, "か", "ら");
		imageDataList.add(imageInfoKamera);
		// がびょう
		ImageInfo imageInfoGabyou = new ImageInfo(R.drawable.gabyou, "が", "う");
		imageDataList.add(imageInfoGabyou);
		// がらす
		ImageInfo imageInfoGarasu = new ImageInfo(R.drawable.garasu, "が", "す");
		imageDataList.add(imageInfoGarasu);
		// ききゅう
		ImageInfo imageInfoKikyuu = new ImageInfo(R.drawable.kikyuu, "き", "う");
		imageDataList.add(imageInfoKikyuu);
		// きつね
		ImageInfo imageInfoKitsune = new ImageInfo(R.drawable.kitsune, "き", "ね");
		imageDataList.add(imageInfoKitsune);
		// きゅうきゅうしゃ
		ImageInfo imageInfoKyuukyuusya = new ImageInfo(R.drawable.kyuukyuusya,
				"き", "や");
		imageDataList.add(imageInfoKyuukyuusya);
		// きりん
		ImageInfo imageInfoKirin = new ImageInfo(R.drawable.kirin, "き", "ん");
		imageDataList.add(imageInfoKirin);
		// ぎたあ
		ImageInfo imageInfoGitaa = new ImageInfo(R.drawable.gitaa, "ぎ", "あ");
		imageDataList.add(imageInfoGitaa);
		// くま
		ImageInfo imageInfoKuma = new ImageInfo(R.drawable.kuma, "く", "ま");
		imageDataList.add(imageInfoKuma);
		// くるま
		ImageInfo imageInfoKuruma = new ImageInfo(R.drawable.kuruma, "く", "ま");
		imageDataList.add(imageInfoKuruma);
		// くれよん
		ImageInfo imageInfoKureyon = new ImageInfo(R.drawable.kureyon, "く", "ん");
		imageDataList.add(imageInfoKureyon);
		// ぐみ
		ImageInfo imageInfoGumi = new ImageInfo(R.drawable.gumi, "ぐ", "み");
		imageDataList.add(imageInfoGumi);
		// ぐろーぶ
		ImageInfo imageInfoGuroobu = new ImageInfo(R.drawable.guroobu, "ぐ", "ぶ");
		imageDataList.add(imageInfoGuroobu);
		// けしごむ
		ImageInfo imageInfoKeshigomu = new ImageInfo(R.drawable.keshigomu, "け",
				"む");
		imageDataList.add(imageInfoKeshigomu);
		// けーき
		ImageInfo imageInfoKeeki = new ImageInfo(R.drawable.keeki, "け", "き");
		imageDataList.add(imageInfoKeeki);
		// げた
		ImageInfo imageInfoGeta = new ImageInfo(R.drawable.geta, "げ", "た");
		imageDataList.add(imageInfoGeta);
		// こいのぼり
		ImageInfo imageInfoKoinobori = new ImageInfo(R.drawable.koinobori, "こ",
				"り");
		imageDataList.add(imageInfoKoinobori);
		// こま
		ImageInfo imageInfoKoma = new ImageInfo(R.drawable.koma, "こ", "ま");
		imageDataList.add(imageInfoKoma);
		// ごぼう
		ImageInfo imageInfoGobou = new ImageInfo(R.drawable.gobou, "ご", "う");
		imageDataList.add(imageInfoGobou);
		// ごりら
		ImageInfo imageInfoGorira = new ImageInfo(R.drawable.gorira, "ご", "ら");
		imageDataList.add(imageInfoGorira);
		// さいふ
		ImageInfo imageInfoSaifu = new ImageInfo(R.drawable.saifu, "さ", "ふ");
		imageDataList.add(imageInfoSaifu);
		// さくらんぼ
		ImageInfo imageInfoSakurannbo = new ImageInfo(R.drawable.sakurannbo,
				"さ", "ぼ");
		imageDataList.add(imageInfoSakurannbo);
		// さんたくろーす
		ImageInfo imageInfoSanntakurousu = new ImageInfo(
				R.drawable.sanntakurousu, "さ", "す");
		imageDataList.add(imageInfoSanntakurousu);
		// しいたけ
		ImageInfo imageInfoSiitake = new ImageInfo(R.drawable.siitake, "し", "け");
		imageDataList.add(imageInfoSiitake);
		// しか
		ImageInfo imageInfoShika = new ImageInfo(R.drawable.shika, "し", "か");
		imageDataList.add(imageInfoShika);
		// しゃぼんだま
		ImageInfo imageInfoSyabonndama = new ImageInfo(R.drawable.syabonndama,
				"し", "ま");
		imageDataList.add(imageInfoSyabonndama);
		// じてんしゃ
		ImageInfo imageInfoJitennsya = new ImageInfo(R.drawable.jitennsya, "じ",
				"や");
		imageDataList.add(imageInfoJitennsya);
		// すいか
		ImageInfo imageInfoSuika = new ImageInfo(R.drawable.suika, "す", "か");
		imageDataList.add(imageInfoSuika);
		// すいとう
		ImageInfo imageInfoSuitou = new ImageInfo(R.drawable.suitou, "す", "う");
		imageDataList.add(imageInfoSuitou);
		// すーぷ
		ImageInfo imageInfoSuupu = new ImageInfo(R.drawable.suupu, "す", "ぷ");
		imageDataList.add(imageInfoSuupu);
		// せみ
		ImageInfo imageInfoSemi = new ImageInfo(R.drawable.semi, "せ", "み");
		imageDataList.add(imageInfoSemi);
		// ぜりー
		ImageInfo imageInfoZerii = new ImageInfo(R.drawable.zerii, "ぜ", "い");
		imageDataList.add(imageInfoZerii);
		// せろはんてえぷ
		ImageInfo imageInfoSerohannteepu = new ImageInfo(
				R.drawable.serohannteepu, "せ", "ぷ");
		imageDataList.add(imageInfoSerohannteepu);
		// せんぷうき
		ImageInfo imageInfoSennpuuki = new ImageInfo(R.drawable.sennpuuki, "せ",
				"き");
		imageDataList.add(imageInfoSennpuuki);
		// そら
		ImageInfo imageInfoSora = new ImageInfo(R.drawable.sora, "そ", "ら");
		imageDataList.add(imageInfoSora);
		// そり
		ImageInfo imageInfoSori = new ImageInfo(R.drawable.sori, "そ", "り");
		imageDataList.add(imageInfoSori);
		// ぞう
		ImageInfo imageInfoZou = new ImageInfo(R.drawable.zou, "ぞ", "う");
		imageDataList.add(imageInfoZou);
		// たいこ
		ImageInfo imageInfoTaiko = new ImageInfo(R.drawable.taiko, "た", "こ");
		imageDataList.add(imageInfoTaiko);
		// たいやき
		ImageInfo imageInfoTaiyaki = new ImageInfo(R.drawable.taiyaki, "た", "き");
		imageDataList.add(imageInfoTaiyaki);
		// たぬき
		ImageInfo imageInfoTanuki = new ImageInfo(R.drawable.tanuki, "た", "き");
		imageDataList.add(imageInfoTanuki);
		// だるま
		ImageInfo imageInfoDaruma = new ImageInfo(R.drawable.daruma, "だ", "ま");
		imageDataList.add(imageInfoDaruma);
		// だんご
		ImageInfo imageInfoDanngo = new ImageInfo(R.drawable.danngo, "だ", "ご");
		imageDataList.add(imageInfoDanngo);
		// ちーず
		ImageInfo imageInfoChiizu = new ImageInfo(R.drawable.chiizu, "ち", "ず");
		imageDataList.add(imageInfoChiizu);
		// ちゅうしゃ
		ImageInfo imageInfoChuusya = new ImageInfo(R.drawable.chuusya, "ち", "や");
		imageDataList.add(imageInfoChuusya);
		// ちょうちょ
		ImageInfo imageInfoTyoutyo = new ImageInfo(R.drawable.tyoutyo, "ち", "よ");
		imageDataList.add(imageInfoTyoutyo);
		// つくし
		ImageInfo imageInfoTsukushi = new ImageInfo(R.drawable.tsukushi, "つ",
				"し");
		imageDataList.add(imageInfoTsukushi);
		// つぼ
		ImageInfo imageInfoTsubo = new ImageInfo(R.drawable.tsubo, "つ", "ぼ");
		imageDataList.add(imageInfoTsubo);
		// つる
		ImageInfo imageInfoTsuru = new ImageInfo(R.drawable.tsuru, "つ", "る");
		imageDataList.add(imageInfoTsuru);
		// てがみ
		ImageInfo imageInfoTegami = new ImageInfo(R.drawable.tegami, "て", "み");
		imageDataList.add(imageInfoTegami);
		// てれび
		ImageInfo imageInfoTerebi = new ImageInfo(R.drawable.terebi, "て", "び");
		imageDataList.add(imageInfoTerebi);
		// てんとうむし
		ImageInfo imageInfoTenntoumushi = new ImageInfo(
				R.drawable.tenntoumushi, "て", "し");
		imageDataList.add(imageInfoTenntoumushi);
		// でんしゃ
		ImageInfo imageInfoDennsya = new ImageInfo(R.drawable.dennsya, "で", "や");
		imageDataList.add(imageInfoDennsya);
		// とけい
		ImageInfo imageInfoTokei = new ImageInfo(R.drawable.tokei, "と", "い");
		imageDataList.add(imageInfoTokei);
		// とまと
		ImageInfo imageInfoTomato = new ImageInfo(R.drawable.tomato, "と", "と");
		imageDataList.add(imageInfoTomato);
		// とんぼ
		ImageInfo imageInfoTonnbo = new ImageInfo(R.drawable.tonnbo, "と", "ぼ");
		imageDataList.add(imageInfoTonnbo);
		// どーなつ
		ImageInfo imageInfoDounatsu = new ImageInfo(R.drawable.dounatsu, "ど",
				"つ");
		imageDataList.add(imageInfoDounatsu);
		// なす
		ImageInfo imageInfoNasu = new ImageInfo(R.drawable.nasu, "な", "す");
		imageDataList.add(imageInfoNasu);
		// なふだ
		ImageInfo imageInfoNafuda = new ImageInfo(R.drawable.nafuda, "な", "だ");
		imageDataList.add(imageInfoNafuda);
		// なまず
		ImageInfo imageInfoNamazu = new ImageInfo(R.drawable.namazu, "な", "ず");
		imageDataList.add(imageInfoNamazu);
		// にじ
		ImageInfo imageInfoNiji = new ImageInfo(R.drawable.niji, "に", "じ");
		imageDataList.add(imageInfoNiji);
		// にんぎょ
		ImageInfo imageInfoNinngyo = new ImageInfo(R.drawable.ninngyo, "に", "よ");
		imageDataList.add(imageInfoNinngyo);
		// にんじん
		ImageInfo imageInfoNinnjin = new ImageInfo(R.drawable.ninnjin, "に", "ん");
		imageDataList.add(imageInfoNinnjin);
		// ぬいぐるみ
		ImageInfo imageInfoNuigurumi = new ImageInfo(R.drawable.nuigurumi, "ぬ",
				"み");
		imageDataList.add(imageInfoNuigurumi);
		// ぬま
		ImageInfo imageInfoNuma = new ImageInfo(R.drawable.numa, "ぬ", "ま");
		imageDataList.add(imageInfoNuma);
		// ねこ
		ImageInfo imageInfoNeko = new ImageInfo(R.drawable.neko, "ね", "こ");
		imageDataList.add(imageInfoNeko);
		// ねずみ
		ImageInfo imageInfoNezumi = new ImageInfo(R.drawable.nezumi, "ね", "み");
		imageDataList.add(imageInfoNezumi);
		// のーと
		ImageInfo imageInfoNote = new ImageInfo(R.drawable.note, "の", "と");
		imageDataList.add(imageInfoNote);
		// はち
		ImageInfo imageInfoHachi = new ImageInfo(R.drawable.hachi, "は", "ち");
		imageDataList.add(imageInfoHachi);
		// はなび
		ImageInfo imageInfoHanabi = new ImageInfo(R.drawable.hanabi, "は", "び");
		imageDataList.add(imageInfoHanabi);
		// ばいおりん
		ImageInfo imageInfoBaiorin = new ImageInfo(R.drawable.baiorin, "ば", "ん");
		imageDataList.add(imageInfoBaiorin);
		// ばいく
		ImageInfo imageInfoBaiku = new ImageInfo(R.drawable.baiku, "ば", "く");
		imageDataList.add(imageInfoBaiku);
		// ばす
		ImageInfo imageInfoBasu = new ImageInfo(R.drawable.basu, "ば", "す");
		imageDataList.add(imageInfoBasu);
		// ばすけっとぼおる
		ImageInfo imageInfoBasukettobouru = new ImageInfo(
				R.drawable.basukettobouru, "ば", "る");
		imageDataList.add(imageInfoBasukettobouru);
		// ぱいなっぷる
		ImageInfo imageInfoPainappuru = new ImageInfo(R.drawable.painappuru,
				"ぱ", "る");
		imageDataList.add(imageInfoPainappuru);
		// ぱそこん
		ImageInfo imageInfoPasokon = new ImageInfo(R.drawable.pasokon, "ぱ", "ん");
		imageDataList.add(imageInfoPasokon);
		// ぱとかー
		ImageInfo imageInfoPatokaa = new ImageInfo(R.drawable.patokaa, "ぱ", "あ");
		imageDataList.add(imageInfoPatokaa);
		// ひこうき
		ImageInfo imageInfoHikouki = new ImageInfo(R.drawable.hikouki, "ひ", "き");
		imageDataList.add(imageInfoHikouki);
		// びいず
		ImageInfo imageInfoBiizu = new ImageInfo(R.drawable.biizu, "び", "ず");
		imageDataList.add(imageInfoBiizu);
		// びーる
		ImageInfo imageInfoBiiru = new ImageInfo(R.drawable.biiru, "び", "る");
		imageDataList.add(imageInfoBiiru);
		// ビスケット
		ImageInfo imageInfoBisuketto = new ImageInfo(R.drawable.bisuketto, "び",
				"る");
		imageDataList.add(imageInfoBisuketto);
		// ぴあの
		ImageInfo imageInfoPiano = new ImageInfo(R.drawable.piano, "ぴ", "の");
		imageDataList.add(imageInfoPiano);
		// ぴいまん
		ImageInfo imageInfoPiiman = new ImageInfo(R.drawable.piiman, "ぴ", "ん");
		imageDataList.add(imageInfoPiiman);
		// ふうしゃ
		ImageInfo imageInfoFuusya = new ImageInfo(R.drawable.fuusya, "ふ", "や");
		imageDataList.add(imageInfoFuusya);
		// ふうせん
		ImageInfo imageInfoFuusen = new ImageInfo(R.drawable.fuusen, "ふ", "ん");
		imageDataList.add(imageInfoFuusen);
		// ふうりん
		ImageInfo imageInfoFuurinn = new ImageInfo(R.drawable.fuurinn, "ふ", "ん");
		imageDataList.add(imageInfoFuurinn);
		// ふぐ
		ImageInfo imageInfoFugu = new ImageInfo(R.drawable.fugu, "ふ", "ぐ");
		imageDataList.add(imageInfoFugu);
		// ぶるどーざ
		ImageInfo imageInfoBurudouza = new ImageInfo(R.drawable.burudouza, "ぶ",
				"ざ");
		imageDataList.add(imageInfoBurudouza);
		// ぷーる
		ImageInfo imageInfoPuuru = new ImageInfo(R.drawable.puuru, "ぷ", "る");
		imageDataList.add(imageInfoPuuru);
		// へりこぷた
		ImageInfo imageInfoHerikoputa = new ImageInfo(R.drawable.herikoputa,
				"へ", "た");
		imageDataList.add(imageInfoHerikoputa);
		// べる
		ImageInfo imageInfoBeru = new ImageInfo(R.drawable.beru, "べ", "る");
		imageDataList.add(imageInfoBeru);
		// べんち
		ImageInfo imageInfoBennchi = new ImageInfo(R.drawable.bennchi, "べ", "ち");
		imageDataList.add(imageInfoBennchi);
		// ぺんぎん
		ImageInfo imageInfoPennginn = new ImageInfo(R.drawable.pennginn, "ぺ",
				"ん");
		imageDataList.add(imageInfoPennginn);
		// ぺんだんと
		ImageInfo imageInfoPenndannto = new ImageInfo(R.drawable.penndannto,
				"ぺ", "と");
		imageDataList.add(imageInfoPenndannto);
		// ほし
		ImageInfo imageInfoHoshi = new ImageInfo(R.drawable.hoshi, "ほ", "し");
		imageDataList.add(imageInfoHoshi);
		// ほっとけーき
		ImageInfo imageInfoHottokeiki = new ImageInfo(R.drawable.hottokeiki,
				"ほ", "き");
		imageDataList.add(imageInfoHottokeiki);
		// ぼうえんきょう
		ImageInfo imageInfoBouenkyou = new ImageInfo(R.drawable.bouenkyou, "ぼ",
				"う");
		imageDataList.add(imageInfoBouenkyou);
		// ぼうし
		ImageInfo imageInfoBousi = new ImageInfo(R.drawable.bousi, "ぼ", "し");
		imageDataList.add(imageInfoBousi);
		// ぽすと
		ImageInfo imageInfoPosuto = new ImageInfo(R.drawable.posuto, "ぽ", "と");
		imageDataList.add(imageInfoPosuto);
		// まつげ
		ImageInfo imageInfoMatsuge = new ImageInfo(R.drawable.matsuge, "ま", "げ");
		imageDataList.add(imageInfoMatsuge);
		// みかづき
		ImageInfo imageInfoMikaduki = new ImageInfo(R.drawable.mikaduki, "み",
				"き");
		imageDataList.add(imageInfoMikaduki);
		// むささび
		ImageInfo imageInfoMusasabi = new ImageInfo(R.drawable.musasabi, "む",
				"び");
		imageDataList.add(imageInfoMusasabi);
		// めだか
		ImageInfo imageInfoMedaka = new ImageInfo(R.drawable.medaka, "め", "か");
		imageDataList.add(imageInfoMedaka);
		// もみじ
		ImageInfo imageInfoMomiji = new ImageInfo(R.drawable.momiji, "も", "じ");
		imageDataList.add(imageInfoMomiji);
		// やかん
		ImageInfo imageInfoYakan = new ImageInfo(R.drawable.yakan, "や", "ん");
		imageDataList.add(imageInfoYakan);
		// やきそば
		ImageInfo imageInfoYakisoba = new ImageInfo(R.drawable.yakisoba, "や",
				"ば");
		imageDataList.add(imageInfoYakisoba);
		// ゆきだるま
		ImageInfo imageInfoYukidaruma = new ImageInfo(R.drawable.yukidaruma,
				"ゆ", "ま");
		imageDataList.add(imageInfoYukidaruma);
		// ゆみ
		ImageInfo imageInfoYumi = new ImageInfo(R.drawable.yumi, "ゆ", "み");
		imageDataList.add(imageInfoYumi);
		// よっと
		ImageInfo imageInfoYotto = new ImageInfo(R.drawable.yotto, "よ", "と");
		imageDataList.add(imageInfoYotto);
		// らいおん
		ImageInfo imageInfoRaion = new ImageInfo(R.drawable.raion, "ら", "ん");
		imageDataList.add(imageInfoRaion);
		// らくだ
		ImageInfo imageInfoRakuda = new ImageInfo(R.drawable.rakuda, "ら", "だ");
		imageDataList.add(imageInfoRakuda);
		// らっぱ
		ImageInfo imageInfoRappa = new ImageInfo(R.drawable.rappa, "ら", "ぱ");
		imageDataList.add(imageInfoRappa);
		// りす
		ImageInfo imageInfoRisu = new ImageInfo(R.drawable.risu, "り", "す");
		imageDataList.add(imageInfoRisu);
		// りんご
		ImageInfo imageInfoRinngo = new ImageInfo(R.drawable.rinngo, "り", "ご");
		imageDataList.add(imageInfoRinngo);
		// るびい
		ImageInfo imageInfoRubii = new ImageInfo(R.drawable.rubii, "る", "い");
		imageDataList.add(imageInfoRubii);
		// れい
		ImageInfo imageInfoRei = new ImageInfo(R.drawable.rei, "れ", "い");
		imageDataList.add(imageInfoRei);
		// ろうそく
		ImageInfo imageInfoRousoku = new ImageInfo(R.drawable.rousoku, "ろ", "く");
		imageDataList.add(imageInfoRousoku);
		// ロケット
		ImageInfo imageInfoRoketto = new ImageInfo(R.drawable.roketto, "ろ", "と");
		imageDataList.add(imageInfoRoketto);
		// わに
		ImageInfo imageInfoWani = new ImageInfo(R.drawable.wani, "わ", "に");
		imageDataList.add(imageInfoWani);

	}

	// 起動時のメイン画像を決定する
	private void SetFirstMainImage() {
		Random rnd = new Random();
		idxMainImage = rnd.nextInt(imageDataList.size());
	}

	// 回答用の画像を決定する
	public void SetSelectImages() {
		Random rnd = new Random();
		numCorrectButton = rnd.nextInt(NUM_ANSWER_BUTTON);
		String correctLetter = imageDataList.get(idxMainImage).GetFinalLetter();

		idxAnswerImages.clear();
		int i = 0;
		while (i < NUM_ANSWER_BUTTON) {
			int tmpNum = rnd.nextInt(imageDataList.size());
			// 前回の単語と、すでに選択ボタンで使われている単語は使用しない
			if (idxMainImage == tmpNum
					|| idxAnswerImages.contains(Integer.valueOf(tmpNum))) {
				continue;
			}
			String initLetter = imageDataList.get(tmpNum).GetInitLetter();
			String finalLetter = imageDataList.get(tmpNum).GetFinalLetter();

			if (numCorrectButton == i) {
				// 正解の画像をセット
				if (correctLetter.equals(initLetter)
						&& !finalLetter.equals("ん")) {
					idxAnswerImages.add(Integer.valueOf(tmpNum));
					i++;
				}
			} else {
				// 不正解の画像をセット
				if (!correctLetter.equals(initLetter)
						|| finalLetter.equals("ん")) {
					idxAnswerImages.add(Integer.valueOf(tmpNum));
					i++;
				}
			}
		}
	}

}
