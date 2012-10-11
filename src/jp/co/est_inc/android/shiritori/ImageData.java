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
		int resId = imageDataList.get(idxMainImage).GetResID();
		int resPhotoId = imageDataList.get(idxMainImage).GetResPhotoID();
		return (resPhotoId == ImageInfo.UNDEFINED_ID) ? resId : resPhotoId;
	}

	// メイン画像を選択したボタンの画像に変更する
	public void SetMainImageByButton(int numButton) {
		idxMainImage = idxAnswerImages.get(numButton).intValue();
	}

	// 回答ボタン(N)の resId を返す
	public int GetAnswerButtonResId(int n) {
		return imageDataList.get(idxAnswerImages.get(n).intValue()).GetResID();
	}
	
	// 回答ボタン(N)の resPhotoId を返す
	public int GetAnswerButtonResPhotoId(int n) {
		int resId = imageDataList.get(idxAnswerImages.get(n).intValue()).GetResID();
		int resPhotoId = imageDataList.get(idxAnswerImages.get(n).intValue()).GetResPhotoID();
		return (resPhotoId == ImageInfo.UNDEFINED_ID) ? resId : resPhotoId;
	}

	// 全画像をリストにセット
	private void CreateImageDataList() {
		// あかちゃん
		ImageInfo imageInfoAkachan = new ImageInfo(R.drawable.akachan, "あ", "ん");
		imageDataList.add(imageInfoAkachan);
		// あめ
		ImageInfo imageInfoAme = new ImageInfo(R.drawable.ame, R.drawable.ame_p, "あ", "め");
		imageDataList.add(imageInfoAme);
		// あり
		ImageInfo imageInfoAri = new ImageInfo(R.drawable.ari, R.drawable.ari_p, "あ", "り");
		imageDataList.add(imageInfoAri);
		// いか
		ImageInfo imageInfoIka = new ImageInfo(R.drawable.ika, R.drawable.ika_p, "い", "か");
		imageDataList.add(imageInfoIka);
		// いちご
		ImageInfo imageInfoIchigo = new ImageInfo(R.drawable.ichigo, R.drawable.ichigo_p, "い", "ご");
		imageDataList.add(imageInfoIchigo);
		// いぬ
		ImageInfo imageInfoInu = new ImageInfo(R.drawable.inu, R.drawable.inu_p, "い", "ぬ");
		imageDataList.add(imageInfoInu);
		// うさぎ
		ImageInfo imageInfoUsagi = new ImageInfo(R.drawable.usagi, R.drawable.usagi_p, "う", "ぎ");
		imageDataList.add(imageInfoUsagi);
		// うちわ
		ImageInfo imageInfoUchiwa = new ImageInfo(R.drawable.uchiwa, R.drawable.uchiwa_p, "う", "わ");
		imageDataList.add(imageInfoUchiwa);
		// えんぴつ
		ImageInfo imageInfoEnpitsu = new ImageInfo(R.drawable.enpitsu, R.drawable.enpitsu_p, "え", "つ");
		imageDataList.add(imageInfoEnpitsu);
		// おかね
		ImageInfo imageInfoOkane = new ImageInfo(R.drawable.okane, R.drawable.okane_p, "お", "ね");
		imageDataList.add(imageInfoOkane);
		// おに
		ImageInfo imageInfoOni = new ImageInfo(R.drawable.oni, R.drawable.oni_p, "お", "に");
		imageDataList.add(imageInfoOni);
		// おにぎり
		ImageInfo imageInfoOnigiri = new ImageInfo(R.drawable.onigiri, R.drawable.onigiri_p, "お", "り");
		imageDataList.add(imageInfoOnigiri);
		// カエル
		ImageInfo imageInfoKaeru = new ImageInfo(R.drawable.kaeru, R.drawable.kaeru_p, "か", "る");
		imageDataList.add(imageInfoKaeru);
		// かきごおり
		ImageInfo imageInfoKakigoori = new ImageInfo(R.drawable.kakigoori, R.drawable.kakigoori_p, "か",
				"り");
		imageDataList.add(imageInfoKakigoori);
		// かすてら
		ImageInfo imageInfoKasutera = new ImageInfo(R.drawable.kasutera, R.drawable.kasutera_p, "か",
				"ら");
		imageDataList.add(imageInfoKasutera);
		// かめ
		ImageInfo imageInfoKame = new ImageInfo(R.drawable.kame, R.drawable.kame_p, "か", "め");
		imageDataList.add(imageInfoKame);
		// かめら
		ImageInfo imageInfoKamera = new ImageInfo(R.drawable.kamera, R.drawable.kamera_p, "か", "ら");
		imageDataList.add(imageInfoKamera);
		// がびょう
		ImageInfo imageInfoGabyou = new ImageInfo(R.drawable.gabyou, R.drawable.gabyou_p, "が", "う");
		imageDataList.add(imageInfoGabyou);
		// がらす
		ImageInfo imageInfoGarasu = new ImageInfo(R.drawable.garasu, R.drawable.garasu_p, "が", "す");
		imageDataList.add(imageInfoGarasu);
		// ききゅう
		ImageInfo imageInfoKikyuu = new ImageInfo(R.drawable.kikyuu, R.drawable.kikyuu_p, "き", "う");
		imageDataList.add(imageInfoKikyuu);
		// きつね
		ImageInfo imageInfoKitsune = new ImageInfo(R.drawable.kitsune, R.drawable.kitsune_p, "き", "ね");
		imageDataList.add(imageInfoKitsune);
		// きゅうきゅうしゃ
		ImageInfo imageInfoKyuukyuusya = new ImageInfo(R.drawable.kyuukyuusya, R.drawable.kyuukyuusya_p,
				"き", "や");
		imageDataList.add(imageInfoKyuukyuusya);
		// きりん
		ImageInfo imageInfoKirin = new ImageInfo(R.drawable.kirin, R.drawable.kirin_p, "き", "ん");
		imageDataList.add(imageInfoKirin);
		// ぎたあ
		ImageInfo imageInfoGitaa = new ImageInfo(R.drawable.gitaa, R.drawable.gitaa_p, "ぎ", "あ");
		imageDataList.add(imageInfoGitaa);
		// くま
		ImageInfo imageInfoKuma = new ImageInfo(R.drawable.kuma, R.drawable.kuma_p, "く", "ま");
		imageDataList.add(imageInfoKuma);
		// くるま
		ImageInfo imageInfoKuruma = new ImageInfo(R.drawable.kuruma, R.drawable.kuruma_p, "く", "ま");
		imageDataList.add(imageInfoKuruma);
		// くれよん
		ImageInfo imageInfoKureyon = new ImageInfo(R.drawable.kureyon, R.drawable.kureyon_p, "く", "ん");
		imageDataList.add(imageInfoKureyon);
		// ぐみ
		ImageInfo imageInfoGumi = new ImageInfo(R.drawable.gumi, R.drawable.gumi_p, "ぐ", "み");
		imageDataList.add(imageInfoGumi);
		// ぐろーぶ
		ImageInfo imageInfoGuroobu = new ImageInfo(R.drawable.guroobu, R.drawable.guroobu_p, "ぐ", "ぶ");
		imageDataList.add(imageInfoGuroobu);
		// けしごむ
		ImageInfo imageInfoKeshigomu = new ImageInfo(R.drawable.keshigomu, R.drawable.keshigomu_p, "け", "む");
		imageDataList.add(imageInfoKeshigomu);
		// けーき
		ImageInfo imageInfoKeeki = new ImageInfo(R.drawable.keeki, R.drawable.keeki_p, "け", "き");
		imageDataList.add(imageInfoKeeki);
		// げた
		ImageInfo imageInfoGeta = new ImageInfo(R.drawable.geta, R.drawable.geta_p, "げ", "た");
		imageDataList.add(imageInfoGeta);
		// こいのぼり
		ImageInfo imageInfoKoinobori = new ImageInfo(R.drawable.koinobori, R.drawable.koinobori_p, "こ", "り");
		imageDataList.add(imageInfoKoinobori);
		// こま
		ImageInfo imageInfoKoma = new ImageInfo(R.drawable.koma, R.drawable.koma_p, "こ", "ま");
		imageDataList.add(imageInfoKoma);
		// ごぼう
		ImageInfo imageInfoGobou = new ImageInfo(R.drawable.gobou, R.drawable.gobou_p, "ご", "う");
		imageDataList.add(imageInfoGobou);
		// ごりら
		ImageInfo imageInfoGorira = new ImageInfo(R.drawable.gorira, R.drawable.gorira_p, "ご", "ら");
		imageDataList.add(imageInfoGorira);
		// さいふ
		ImageInfo imageInfoSaifu = new ImageInfo(R.drawable.saifu, R.drawable.saifu_p, "さ", "ふ");
		imageDataList.add(imageInfoSaifu);
		// さくらんぼ
		ImageInfo imageInfoSakurannbo = new ImageInfo(R.drawable.sakurannbo, R.drawable.sakurannbo_p, "さ", "ぼ");
		imageDataList.add(imageInfoSakurannbo);
		// さんたくろーす
		ImageInfo imageInfoSanntakurousu = new ImageInfo(R.drawable.sanntakurousu, R.drawable.sanntakurousu_p, "さ", "す");
		imageDataList.add(imageInfoSanntakurousu);
		// しいたけ
		ImageInfo imageInfoSiitake = new ImageInfo(R.drawable.siitake, R.drawable.siitake_p, "し", "け");
		imageDataList.add(imageInfoSiitake);
		// しか
		ImageInfo imageInfoShika = new ImageInfo(R.drawable.shika, R.drawable.shika_p, "し", "か");
		imageDataList.add(imageInfoShika);
		// しゃぼんだま
		ImageInfo imageInfoSyabonndama = new ImageInfo(R.drawable.syabonndama, R.drawable.syabonndama_p, "し", "ま");
		imageDataList.add(imageInfoSyabonndama);
		// じてんしゃ
		ImageInfo imageInfoJitennsya = new ImageInfo(R.drawable.jitennsya, R.drawable.jitennsya_p, "じ", "や");
		imageDataList.add(imageInfoJitennsya);
		// すいか
		ImageInfo imageInfoSuika = new ImageInfo(R.drawable.suika, R.drawable.suika_p, "す", "か");
		imageDataList.add(imageInfoSuika);
		// すいとう
		ImageInfo imageInfoSuitou = new ImageInfo(R.drawable.suitou, R.drawable.suitou_p, "す", "う");
		imageDataList.add(imageInfoSuitou);
		// すーぷ
		ImageInfo imageInfoSuupu = new ImageInfo(R.drawable.suupu, R.drawable.suupu_p, "す", "ぷ");
		imageDataList.add(imageInfoSuupu);
		// せみ
		ImageInfo imageInfoSemi = new ImageInfo(R.drawable.semi, R.drawable.semi_p, "せ", "み");
		imageDataList.add(imageInfoSemi);
		// ぜりー
		ImageInfo imageInfoZerii = new ImageInfo(R.drawable.zerii, R.drawable.zerii_p, "ぜ", "い");
		imageDataList.add(imageInfoZerii);
		// せろはんてえぷ
		ImageInfo imageInfoSerohannteepu = new ImageInfo(R.drawable.serohannteepu, R.drawable.serohannteepu_p, "せ", "ぷ");
		imageDataList.add(imageInfoSerohannteepu);
		// せんぷうき
		ImageInfo imageInfoSennpuuki = new ImageInfo(R.drawable.sennpuuki, R.drawable.sennpuuki_p, "せ", "き");
		imageDataList.add(imageInfoSennpuuki);
		// そら
		ImageInfo imageInfoSora = new ImageInfo(R.drawable.sora, R.drawable.sora_p, "そ", "ら");
		imageDataList.add(imageInfoSora);
		// そり
		ImageInfo imageInfoSori = new ImageInfo(R.drawable.sori, R.drawable.sori_p, "そ", "り");
		imageDataList.add(imageInfoSori);
		// ぞう
		ImageInfo imageInfoZou = new ImageInfo(R.drawable.zou, R.drawable.zou_p, "ぞ", "う");
		imageDataList.add(imageInfoZou);
		// たいこ
		ImageInfo imageInfoTaiko = new ImageInfo(R.drawable.taiko, R.drawable.taiko_p, "た", "こ");
		imageDataList.add(imageInfoTaiko);
		// たいやき
		ImageInfo imageInfoTaiyaki = new ImageInfo(R.drawable.taiyaki, R.drawable.taiyaki_p, "た", "き");
		imageDataList.add(imageInfoTaiyaki);
		// たぬき
		ImageInfo imageInfoTanuki = new ImageInfo(R.drawable.tanuki, R.drawable.tanuki_p, "た", "き");
		imageDataList.add(imageInfoTanuki);
		// だるま
		ImageInfo imageInfoDaruma = new ImageInfo(R.drawable.daruma, R.drawable.daruma_p, "だ", "ま");
		imageDataList.add(imageInfoDaruma);
		// だんご
		ImageInfo imageInfoDanngo = new ImageInfo(R.drawable.danngo, R.drawable.danngo_p, "だ", "ご");
		imageDataList.add(imageInfoDanngo);
		// ちーず
		ImageInfo imageInfoChiizu = new ImageInfo(R.drawable.chiizu, R.drawable.chiizu_p, "ち", "ず");
		imageDataList.add(imageInfoChiizu);
		// ちゅうしゃ
		ImageInfo imageInfoChuusya = new ImageInfo(R.drawable.chuusya, R.drawable.chuusya_p, "ち", "や");
		imageDataList.add(imageInfoChuusya);
		// ちょうちょ
		ImageInfo imageInfoTyoutyo = new ImageInfo(R.drawable.tyoutyo, R.drawable.tyoutyo_p, "ち", "よ");
		imageDataList.add(imageInfoTyoutyo);
		// つくし
		ImageInfo imageInfoTsukushi = new ImageInfo(R.drawable.tsukushi, R.drawable.tsukushi_p, "つ", "し");
		imageDataList.add(imageInfoTsukushi);
		// つぼ
		ImageInfo imageInfoTsubo = new ImageInfo(R.drawable.tsubo, R.drawable.tsubo_p, "つ", "ぼ");
		imageDataList.add(imageInfoTsubo);
		// つる
		ImageInfo imageInfoTsuru = new ImageInfo(R.drawable.tsuru, R.drawable.tsuru_p, "つ", "る");
		imageDataList.add(imageInfoTsuru);
		// てがみ
		ImageInfo imageInfoTegami = new ImageInfo(R.drawable.tegami, R.drawable.tegami_p, "て", "み");
		imageDataList.add(imageInfoTegami);
		// てれび
		ImageInfo imageInfoTerebi = new ImageInfo(R.drawable.terebi, R.drawable.terebi_p, "て", "び");
		imageDataList.add(imageInfoTerebi);
		// てんとうむし
		ImageInfo imageInfoTenntoumushi = new ImageInfo(R.drawable.tenntoumushi, R.drawable.tenntoumushi_p, "て", "し");
		imageDataList.add(imageInfoTenntoumushi);
		// でんしゃ
		ImageInfo imageInfoDennsya = new ImageInfo(R.drawable.dennsya, R.drawable.dennsya_p, "で", "や");
		imageDataList.add(imageInfoDennsya);
		// とけい
		ImageInfo imageInfoTokei = new ImageInfo(R.drawable.tokei, R.drawable.tokei_p, "と", "い");
		imageDataList.add(imageInfoTokei);
		// とまと
		ImageInfo imageInfoTomato = new ImageInfo(R.drawable.tomato, R.drawable.tomato_p, "と", "と");
		imageDataList.add(imageInfoTomato);
		// とんぼ
		ImageInfo imageInfoTonnbo = new ImageInfo(R.drawable.tonnbo, R.drawable.tonnbo_p, "と", "ぼ");
		imageDataList.add(imageInfoTonnbo);
		// どーなつ
		ImageInfo imageInfoDounatsu = new ImageInfo(R.drawable.dounatsu, R.drawable.dounatsu_p, "ど", "つ");
		imageDataList.add(imageInfoDounatsu);
		// なす
		ImageInfo imageInfoNasu = new ImageInfo(R.drawable.nasu, R.drawable.nasu_p, "な", "す");
		imageDataList.add(imageInfoNasu);
		// なふだ
		ImageInfo imageInfoNafuda = new ImageInfo(R.drawable.nafuda, R.drawable.nafuda_p, "な", "だ");
		imageDataList.add(imageInfoNafuda);
		// なまず
		ImageInfo imageInfoNamazu = new ImageInfo(R.drawable.namazu, R.drawable.namazu_p, "な", "ず");
		imageDataList.add(imageInfoNamazu);
		// にじ
		ImageInfo imageInfoNiji = new ImageInfo(R.drawable.niji, R.drawable.niji_p, "に", "じ");
		imageDataList.add(imageInfoNiji);
		// にんぎょ
		ImageInfo imageInfoNinngyo = new ImageInfo(R.drawable.ninngyo, R.drawable.ninngyo_p, "に", "よ");
		imageDataList.add(imageInfoNinngyo);
		// にんじん
		ImageInfo imageInfoNinnjin = new ImageInfo(R.drawable.ninnjin, R.drawable.ninnjin_p, "に", "ん");
		imageDataList.add(imageInfoNinnjin);
		// ぬいぐるみ
		ImageInfo imageInfoNuigurumi = new ImageInfo(R.drawable.nuigurumi, R.drawable.nuigurumi_p, "ぬ",	"み");
		imageDataList.add(imageInfoNuigurumi);
		// ぬま
		ImageInfo imageInfoNuma = new ImageInfo(R.drawable.numa, R.drawable.numa_p, "ぬ", "ま");
		imageDataList.add(imageInfoNuma);
		// ねこ
		ImageInfo imageInfoNeko = new ImageInfo(R.drawable.neko, R.drawable.neko_p, "ね", "こ");
		imageDataList.add(imageInfoNeko);
		// ねずみ
		ImageInfo imageInfoNezumi = new ImageInfo(R.drawable.nezumi, R.drawable.nezumi_p, "ね", "み");
		imageDataList.add(imageInfoNezumi);
		// のーと
		ImageInfo imageInfoNote = new ImageInfo(R.drawable.note, R.drawable.note_p, "の", "と");
		imageDataList.add(imageInfoNote);
		// はち
		ImageInfo imageInfoHachi = new ImageInfo(R.drawable.hachi, R.drawable.hachi_p, "は", "ち");
		imageDataList.add(imageInfoHachi);
		// はなび
		ImageInfo imageInfoHanabi = new ImageInfo(R.drawable.hanabi, R.drawable.hanabi_p, "は", "び");
		imageDataList.add(imageInfoHanabi);
		// ばいおりん
		ImageInfo imageInfoBaiorin = new ImageInfo(R.drawable.baiorin, R.drawable.baiorin_p, "ば", "ん");
		imageDataList.add(imageInfoBaiorin);
		// ばいく
		ImageInfo imageInfoBaiku = new ImageInfo(R.drawable.baiku, R.drawable.baiku_p, "ば", "く");
		imageDataList.add(imageInfoBaiku);
		// ばす
		ImageInfo imageInfoBasu = new ImageInfo(R.drawable.basu, R.drawable.basu_p, "ば", "す");
		imageDataList.add(imageInfoBasu);
		// ばすけっとぼおる
		ImageInfo imageInfoBasukettobouru = new ImageInfo(R.drawable.basukettobouru, R.drawable.basukettobouru_p, "ば", "る");
		imageDataList.add(imageInfoBasukettobouru);
		// ぱいなっぷる
		ImageInfo imageInfoPainappuru = new ImageInfo(R.drawable.painappuru, R.drawable.painappuru_p, "ぱ", "る");
		imageDataList.add(imageInfoPainappuru);
		// ぱそこん
		ImageInfo imageInfoPasokon = new ImageInfo(R.drawable.pasokon, R.drawable.pasokon_p, "ぱ", "ん");
		imageDataList.add(imageInfoPasokon);
		// ぱとかー
		ImageInfo imageInfoPatokaa = new ImageInfo(R.drawable.patokaa, R.drawable.patokaa_p, "ぱ", "あ");
		imageDataList.add(imageInfoPatokaa);
		// ひこうき
		ImageInfo imageInfoHikouki = new ImageInfo(R.drawable.hikouki, R.drawable.hikouki_p, "ひ", "き");
		imageDataList.add(imageInfoHikouki);
		// びいず
		ImageInfo imageInfoBiizu = new ImageInfo(R.drawable.biizu, R.drawable.biizu_p, "び", "ず");
		imageDataList.add(imageInfoBiizu);
		// びーる
		ImageInfo imageInfoBiiru = new ImageInfo(R.drawable.biiru, R.drawable.biiru_p, "び", "る");
		imageDataList.add(imageInfoBiiru);
		// ビスケット
		ImageInfo imageInfoBisuketto = new ImageInfo(R.drawable.bisuketto, R.drawable.bisuketto_p, "び", "る");
		imageDataList.add(imageInfoBisuketto);
		// ぴあの
		ImageInfo imageInfoPiano = new ImageInfo(R.drawable.piano, R.drawable.piano_p, "ぴ", "の");
		imageDataList.add(imageInfoPiano);
		// ぴいまん
		ImageInfo imageInfoPiiman = new ImageInfo(R.drawable.piiman, R.drawable.piiman_p, "ぴ", "ん");
		imageDataList.add(imageInfoPiiman);
		// ふうしゃ
		ImageInfo imageInfoFuusya = new ImageInfo(R.drawable.fuusya, R.drawable.fuusya_p, "ふ", "や");
		imageDataList.add(imageInfoFuusya);
		// ふうせん
		ImageInfo imageInfoFuusen = new ImageInfo(R.drawable.fuusen, R.drawable.fuusen_p, "ふ", "ん");
		imageDataList.add(imageInfoFuusen);
		// ふうりん
		ImageInfo imageInfoFuurinn = new ImageInfo(R.drawable.fuurinn, R.drawable.fuurinn_p, "ふ", "ん");
		imageDataList.add(imageInfoFuurinn);
		// ふぐ
		ImageInfo imageInfoFugu = new ImageInfo(R.drawable.fugu, R.drawable.fugu_p, "ふ", "ぐ");
		imageDataList.add(imageInfoFugu);
		// ぶるどーざ
		ImageInfo imageInfoBurudouza = new ImageInfo(R.drawable.burudouza, R.drawable.burudouza_p, "ぶ", "ざ");
		imageDataList.add(imageInfoBurudouza);
		// ぷーる
		ImageInfo imageInfoPuuru = new ImageInfo(R.drawable.puuru, R.drawable.puuru_p, "ぷ", "る");
		imageDataList.add(imageInfoPuuru);
		// へりこぷた
		ImageInfo imageInfoHerikoputa = new ImageInfo(R.drawable.herikoputa, R.drawable.herikoputa_p, "へ", "た");
		imageDataList.add(imageInfoHerikoputa);
		// べる
		ImageInfo imageInfoBeru = new ImageInfo(R.drawable.beru, R.drawable.beru_p, "べ", "る");
		imageDataList.add(imageInfoBeru);
		// べんち
		ImageInfo imageInfoBennchi = new ImageInfo(R.drawable.bennchi, R.drawable.bennchi_p, "べ", "ち");
		imageDataList.add(imageInfoBennchi);
		// ぺんぎん
		ImageInfo imageInfoPennginn = new ImageInfo(R.drawable.pennginn, R.drawable.pennginn_p, "ぺ", "ん");
		imageDataList.add(imageInfoPennginn);
		// ぺんだんと
		ImageInfo imageInfoPenndannto = new ImageInfo(R.drawable.penndannto, R.drawable.penndannto_p, "ぺ", "と");
		imageDataList.add(imageInfoPenndannto);
		// ほし
		ImageInfo imageInfoHoshi = new ImageInfo(R.drawable.hoshi, R.drawable.hoshi_p, "ほ", "し");
		imageDataList.add(imageInfoHoshi);
		// ほっとけーき
		ImageInfo imageInfoHottokeiki = new ImageInfo(R.drawable.hottokeiki, R.drawable.hottokeiki_p, "ほ", "き");
		imageDataList.add(imageInfoHottokeiki);
		// ぼうえんきょう
		ImageInfo imageInfoBouenkyou = new ImageInfo(R.drawable.bouenkyou, R.drawable.bouenkyou_p, "ぼ", "う");
		imageDataList.add(imageInfoBouenkyou);
		// ぼうし
		ImageInfo imageInfoBousi = new ImageInfo(R.drawable.bousi, R.drawable.bousi_p, "ぼ", "し");
		imageDataList.add(imageInfoBousi);
		// ぽすと
		ImageInfo imageInfoPosuto = new ImageInfo(R.drawable.posuto, R.drawable.posuto_p, "ぽ", "と");
		imageDataList.add(imageInfoPosuto);
		// まつげ
		ImageInfo imageInfoMatsuge = new ImageInfo(R.drawable.matsuge, R.drawable.matsuge_p, "ま", "げ");
		imageDataList.add(imageInfoMatsuge);
		// みかづき
		ImageInfo imageInfoMikaduki = new ImageInfo(R.drawable.mikaduki, R.drawable.mikaduki_p, "み", "き");
		imageDataList.add(imageInfoMikaduki);
		// むささび
		ImageInfo imageInfoMusasabi = new ImageInfo(R.drawable.musasabi, R.drawable.musasabi_p, "む", "び");
		imageDataList.add(imageInfoMusasabi);
		// めだか
		ImageInfo imageInfoMedaka = new ImageInfo(R.drawable.medaka, R.drawable.medaka_p, "め", "か");
		imageDataList.add(imageInfoMedaka);
		// もみじ
		ImageInfo imageInfoMomiji = new ImageInfo(R.drawable.momiji, R.drawable.momiji_p, "も", "じ");
		imageDataList.add(imageInfoMomiji);
		// やかん
		ImageInfo imageInfoYakan = new ImageInfo(R.drawable.yakan, R.drawable.yakan_p, "や", "ん");
		imageDataList.add(imageInfoYakan);
		// やきそば
		ImageInfo imageInfoYakisoba = new ImageInfo(R.drawable.yakisoba, R.drawable.yakisoba_p, "や", "ば");
		imageDataList.add(imageInfoYakisoba);
		// ゆきだるま
		ImageInfo imageInfoYukidaruma = new ImageInfo(R.drawable.yukidaruma, R.drawable.yukidaruma_p, "ゆ", "ま");
		imageDataList.add(imageInfoYukidaruma);
		// ゆみ
		ImageInfo imageInfoYumi = new ImageInfo(R.drawable.yumi, R.drawable.yumi_p, "ゆ", "み");
		imageDataList.add(imageInfoYumi);
		// よっと
		ImageInfo imageInfoYotto = new ImageInfo(R.drawable.yotto, R.drawable.yotto_p, "よ", "と");
		imageDataList.add(imageInfoYotto);
		// らいおん
		ImageInfo imageInfoRaion = new ImageInfo(R.drawable.raion, R.drawable.raion_p, "ら", "ん");
		imageDataList.add(imageInfoRaion);
		// らくだ
		ImageInfo imageInfoRakuda = new ImageInfo(R.drawable.rakuda, R.drawable.rakuda_p, "ら", "だ");
		imageDataList.add(imageInfoRakuda);
		// らっぱ
		ImageInfo imageInfoRappa = new ImageInfo(R.drawable.rappa, R.drawable.rappa_p, "ら", "ぱ");
		imageDataList.add(imageInfoRappa);
		// りす
		ImageInfo imageInfoRisu = new ImageInfo(R.drawable.risu, R.drawable.risu_p, "り", "す");
		imageDataList.add(imageInfoRisu);
		// りんご
		ImageInfo imageInfoRinngo = new ImageInfo(R.drawable.rinngo, R.drawable.rinngo_p, "り", "ご");
		imageDataList.add(imageInfoRinngo);
		// るびい
		ImageInfo imageInfoRubii = new ImageInfo(R.drawable.rubii, R.drawable.rubii_p, "る", "い");
		imageDataList.add(imageInfoRubii);
		// れい
		ImageInfo imageInfoRei = new ImageInfo(R.drawable.rei, "れ", "い");
		imageDataList.add(imageInfoRei);
		// ろうそく
		ImageInfo imageInfoRousoku = new ImageInfo(R.drawable.rousoku, R.drawable.rousoku_p, "ろ", "く");
		imageDataList.add(imageInfoRousoku);
		// ロケット
		ImageInfo imageInfoRoketto = new ImageInfo(R.drawable.roketto, R.drawable.roketto_p, "ろ", "と");
		imageDataList.add(imageInfoRoketto);
		// わに
		ImageInfo imageInfoWani = new ImageInfo(R.drawable.wani, R.drawable.wani_p, "わ", "に");
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
