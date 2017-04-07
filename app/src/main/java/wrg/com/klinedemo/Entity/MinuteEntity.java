package wrg.com.klinedemo.Entity;

import java.util.List;

/**
 * Created by 翁 on 2017/3/24.
 */

public class MinuteEntity {

    /**
     * MsgType : fs
     * RefMsgType : fs
     * MsgSeqNum : 781
     * Data : [{"ID":"000001.SZ","TrdTm":"2017-03-24 09:30:00","LastPx":9.2,"TrdVol":416357,"TrdAmt":3831115.3999},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:31:00","LastPx":9.2,"TrdVol":582497,"TrdAmt":5360849.3999},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:32:00","LastPx":9.22,"TrdVol":683897,"TrdAmt":6294555.3999},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:33:00","LastPx":9.22,"TrdVol":908548,"TrdAmt":8363402.5999},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:34:00","LastPx":9.22,"TrdVol":1092648,"TrdAmt":1.00602789999E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:35:00","LastPx":9.22,"TrdVol":1198585,"TrdAmt":1.10363905599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:36:00","LastPx":9.21,"TrdVol":1284001,"TrdAmt":1.18233439199E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:37:00","LastPx":9.22,"TrdVol":1647686,"TrdAmt":1.51770154599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:38:00","LastPx":9.22,"TrdVol":1855917,"TrdAmt":1.70978212799E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:39:00","LastPx":9.22,"TrdVol":2117629,"TrdAmt":1.95121669199E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:40:00","LastPx":9.23,"TrdVol":2211380,"TrdAmt":2.03771211399E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:41:00","LastPx":9.22,"TrdVol":2307291,"TrdAmt":2.12616895599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:42:00","LastPx":9.22,"TrdVol":2426602,"TrdAmt":2.23625459799E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:43:00","LastPx":9.22,"TrdVol":2556014,"TrdAmt":2.35565816199E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:44:00","LastPx":9.22,"TrdVol":2898425,"TrdAmt":2.67136410399E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:45:00","LastPx":9.22,"TrdVol":3009576,"TrdAmt":2.77387422599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:46:00","LastPx":9.23,"TrdVol":3088188,"TrdAmt":2.84638358999E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:47:00","LastPx":9.22,"TrdVol":3261819,"TrdAmt":3.00647857199E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:48:00","LastPx":9.23,"TrdVol":3327430,"TrdAmt":3.06699451399E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:49:00","LastPx":9.22,"TrdVol":3472041,"TrdAmt":3.20039425599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:50:00","LastPx":9.22,"TrdVol":3551472,"TrdAmt":3.27368033799E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:51:00","LastPx":9.22,"TrdVol":3602484,"TrdAmt":3.32073070199E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:52:00","LastPx":9.23,"TrdVol":3689095,"TrdAmt":3.40061524399E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:53:00","LastPx":9.23,"TrdVol":3874786,"TrdAmt":3.57196644599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:54:00","LastPx":9.23,"TrdVol":4002257,"TrdAmt":3.68954970799E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:55:00","LastPx":9.22,"TrdVol":4111277,"TrdAmt":3.79008564799E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:56:00","LastPx":9.23,"TrdVol":4368077,"TrdAmt":4.02687124799E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:57:00","LastPx":9.22,"TrdVol":4505501,"TrdAmt":4.15359147599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:58:00","LastPx":9.21,"TrdVol":4797086,"TrdAmt":4.42242234599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 09:59:00","LastPx":9.21,"TrdVol":4863686,"TrdAmt":4.48379204599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:00:00","LastPx":9.22,"TrdVol":4913486,"TrdAmt":4.52968314599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:01:00","LastPx":9.22,"TrdVol":5026266,"TrdAmt":4.63364392599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:02:00","LastPx":9.21,"TrdVol":5171866,"TrdAmt":4.76787232599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:03:00","LastPx":9.22,"TrdVol":5394366,"TrdAmt":4.97299342599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:04:00","LastPx":9.22,"TrdVol":5449066,"TrdAmt":5.02341792599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:05:00","LastPx":9.22,"TrdVol":5549966,"TrdAmt":5.11642722599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:06:00","LastPx":9.22,"TrdVol":5579666,"TrdAmt":5.14380712599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:07:00","LastPx":9.23,"TrdVol":5877106,"TrdAmt":5.41822058599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:08:00","LastPx":9.23,"TrdVol":5912106,"TrdAmt":5.45050338599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:09:00","LastPx":9.22,"TrdVol":6961026,"TrdAmt":6.41695080599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:10:00","LastPx":9.21,"TrdVol":7059146,"TrdAmt":6.50739462599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:11:00","LastPx":9.22,"TrdVol":7481495,"TrdAmt":6.89642675499E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:12:00","LastPx":9.22,"TrdVol":7533739,"TrdAmt":6.94458297899E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:13:00","LastPx":9.22,"TrdVol":7840739,"TrdAmt":7.22735177899E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:14:00","LastPx":9.22,"TrdVol":7968839,"TrdAmt":7.34537877899E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:15:00","LastPx":9.22,"TrdVol":8060839,"TrdAmt":7.43014767899E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:16:00","LastPx":9.22,"TrdVol":8517271,"TrdAmt":7.85099128299E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:17:00","LastPx":9.22,"TrdVol":8641071,"TrdAmt":7.96521518299E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:18:00","LastPx":9.23,"TrdVol":8685471,"TrdAmt":8.00617978299E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:19:00","LastPx":9.22,"TrdVol":8741031,"TrdAmt":8.05742870299E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:20:00","LastPx":9.23,"TrdVol":8884525,"TrdAmt":8.18976967099E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:21:00","LastPx":9.22,"TrdVol":8942565,"TrdAmt":8.24331785099E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:22:00","LastPx":9.22,"TrdVol":9164805,"TrdAmt":8.44822933099E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:23:00","LastPx":9.23,"TrdVol":9262705,"TrdAmt":8.53852613099E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:24:00","LastPx":9.22,"TrdVol":9611705,"TrdAmt":8.86064103099E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:25:00","LastPx":9.22,"TrdVol":9677005,"TrdAmt":8.92089693099E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:26:00","LastPx":9.22,"TrdVol":9941805,"TrdAmt":9.16509283099E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:27:00","LastPx":9.22,"TrdVol":10172739,"TrdAmt":9.37799497899E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:28:00","LastPx":9.22,"TrdVol":10306372,"TrdAmt":9.50121620499E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:29:00","LastPx":9.22,"TrdVol":10458039,"TrdAmt":9.64103597899E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:30:00","LastPx":9.22,"TrdVol":10558739,"TrdAmt":9.73379697899E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:31:00","LastPx":9.22,"TrdVol":10657139,"TrdAmt":9.82451794599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:32:00","LastPx":9.22,"TrdVol":10686839,"TrdAmt":9.85190524599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:33:00","LastPx":9.22,"TrdVol":10756339,"TrdAmt":9.91601774599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:34:00","LastPx":9.22,"TrdVol":10792379,"TrdAmt":9.94925412599E7},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:35:00","LastPx":9.22,"TrdVol":10986079,"TrdAmt":1.012801852599E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:36:00","LastPx":9.23,"TrdVol":11123279,"TrdAmt":1.025458812599E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:37:00","LastPx":9.23,"TrdVol":11193579,"TrdAmt":1.031942072599E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:38:00","LastPx":9.22,"TrdVol":11410720,"TrdAmt":1.051980652799E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:39:00","LastPx":9.22,"TrdVol":11624640,"TrdAmt":1.071712226799E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:40:00","LastPx":9.22,"TrdVol":11706729,"TrdAmt":1.079285312599E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:41:00","LastPx":9.22,"TrdVol":11737629,"TrdAmt":1.082135372599E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:42:00","LastPx":9.23,"TrdVol":11812892,"TrdAmt":1.089077181199E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:43:00","LastPx":9.22,"TrdVol":11837692,"TrdAmt":1.091363831199E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:44:00","LastPx":9.23,"TrdVol":11941892,"TrdAmt":1.100976991199E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:45:00","LastPx":9.23,"TrdVol":11979116,"TrdAmt":1.104409623999E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:46:00","LastPx":9.23,"TrdVol":12039116,"TrdAmt":1.109944033999E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:47:00","LastPx":9.22,"TrdVol":12100636,"TrdAmt":1.115617637999E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:48:00","LastPx":9.22,"TrdVol":12146736,"TrdAmt":1.119869057999E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:49:00","LastPx":9.23,"TrdVol":12937323,"TrdAmt":1.192838885399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:50:00","LastPx":9.23,"TrdVol":13088763,"TrdAmt":1.206818357399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:51:00","LastPx":9.24,"TrdVol":13447223,"TrdAmt":1.239912423399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:52:00","LastPx":9.23,"TrdVol":13486183,"TrdAmt":1.243509971399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:53:00","LastPx":9.23,"TrdVol":13684983,"TrdAmt":1.261865875399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:54:00","LastPx":9.24,"TrdVol":13760723,"TrdAmt":1.268856447399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:55:00","LastPx":9.23,"TrdVol":13823023,"TrdAmt":1.274606767399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:56:00","LastPx":9.22,"TrdVol":13871403,"TrdAmt":1.279071979399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:57:00","LastPx":9.24,"TrdVol":14069363,"TrdAmt":1.297345297399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:58:00","LastPx":9.23,"TrdVol":14107063,"TrdAmt":1.300826507399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 10:59:00","LastPx":9.23,"TrdVol":14209564,"TrdAmt":1.310295409699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:00:00","LastPx":9.23,"TrdVol":14279364,"TrdAmt":1.316740789699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:01:00","LastPx":9.23,"TrdVol":14307204,"TrdAmt":1.319311901699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:02:00","LastPx":9.23,"TrdVol":14348882,"TrdAmt":1.323160401099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:03:00","LastPx":9.23,"TrdVol":14500182,"TrdAmt":1.337128271099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:04:00","LastPx":9.23,"TrdVol":14537882,"TrdAmt":1.340608981099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:05:00","LastPx":9.22,"TrdVol":14674603,"TrdAmt":1.353229649399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:06:00","LastPx":9.23,"TrdVol":15035103,"TrdAmt":1.386515301499E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:07:00","LastPx":9.22,"TrdVol":15172503,"TrdAmt":1.399197271499E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:08:00","LastPx":9.22,"TrdVol":15235703,"TrdAmt":1.405027841499E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:09:00","LastPx":9.22,"TrdVol":15268882,"TrdAmt":1.408089415299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:10:00","LastPx":9.23,"TrdVol":15334382,"TrdAmt":1.414134575299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:11:00","LastPx":9.23,"TrdVol":15407802,"TrdAmt":1.420912771299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:12:00","LastPx":9.23,"TrdVol":15530682,"TrdAmt":1.432254585299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:13:00","LastPx":9.22,"TrdVol":15557032,"TrdAmt":1.434684875299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:14:00","LastPx":9.22,"TrdVol":15597932,"TrdAmt":1.438458935299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:15:00","LastPx":9.22,"TrdVol":15615432,"TrdAmt":1.440073135299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:16:00","LastPx":9.22,"TrdVol":15676632,"TrdAmt":1.445718035299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:17:00","LastPx":9.22,"TrdVol":15959432,"TrdAmt":1.471792855299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:18:00","LastPx":9.22,"TrdVol":16032152,"TrdAmt":1.478498129299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:19:00","LastPx":9.23,"TrdVol":16090752,"TrdAmt":1.483902569299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:20:00","LastPx":9.23,"TrdVol":16181452,"TrdAmt":1.492266289299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:21:00","LastPx":9.22,"TrdVol":16256352,"TrdAmt":1.499172599299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:22:00","LastPx":9.22,"TrdVol":16276312,"TrdAmt":1.501012921299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:23:00","LastPx":9.23,"TrdVol":16304212,"TrdAmt":1.503586031299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:24:00","LastPx":9.22,"TrdVol":16342012,"TrdAmt":1.507072441299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:25:00","LastPx":9.22,"TrdVol":16435131,"TrdAmt":1.515659963099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:26:00","LastPx":9.23,"TrdVol":16472031,"TrdAmt":1.519062753099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:27:00","LastPx":9.23,"TrdVol":16645331,"TrdAmt":1.535042173099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:28:00","LastPx":9.22,"TrdVol":16688431,"TrdAmt":1.539017383099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:29:00","LastPx":9.23,"TrdVol":16724485,"TrdAmt":1.542344031899E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 11:30:00","LastPx":9.23,"TrdVol":16726287,"TrdAmt":1.542510326299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:00:00","LastPx":9.22,"TrdVol":18291279,"TrdAmt":1.686807194699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:01:00","LastPx":9.21,"TrdVol":18567274,"TrdAmt":1.712231084199E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:02:00","LastPx":9.22,"TrdVol":19353794,"TrdAmt":1.784657360699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:03:00","LastPx":9.21,"TrdVol":19560314,"TrdAmt":1.803685140699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:04:00","LastPx":9.2,"TrdVol":19646214,"TrdAmt":1.811589400699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:05:00","LastPx":9.2,"TrdVol":19744094,"TrdAmt":1.820597980699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:06:00","LastPx":9.21,"TrdVol":19858134,"TrdAmt":1.831098894699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:07:00","LastPx":9.2,"TrdVol":19907134,"TrdAmt":1.835610220699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:08:00","LastPx":9.21,"TrdVol":20177234,"TrdAmt":1.860465060699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:09:00","LastPx":9.2,"TrdVol":21007134,"TrdAmt":1.936859510699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:10:00","LastPx":9.2,"TrdVol":21062186,"TrdAmt":1.941925594699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:11:00","LastPx":9.2,"TrdVol":21206486,"TrdAmt":1.955203274699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:12:00","LastPx":9.2,"TrdVol":21677706,"TrdAmt":1.998524081099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:13:00","LastPx":9.18,"TrdVol":21997170,"TrdAmt":2.027869649099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:14:00","LastPx":9.18,"TrdVol":22204270,"TrdAmt":2.046886099099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:15:00","LastPx":9.19,"TrdVol":22380070,"TrdAmt":2.063026229099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:16:00","LastPx":9.19,"TrdVol":22611971,"TrdAmt":2.084328960999E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:17:00","LastPx":9.18,"TrdVol":22760930,"TrdAmt":2.098009587099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:18:00","LastPx":9.18,"TrdVol":22958330,"TrdAmt":2.116133027099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:19:00","LastPx":9.18,"TrdVol":23110410,"TrdAmt":2.130097521099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:20:00","LastPx":9.18,"TrdVol":23409910,"TrdAmt":2.157604651099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:21:00","LastPx":9.18,"TrdVol":23614510,"TrdAmt":2.176394381099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:22:00","LastPx":9.18,"TrdVol":23731710,"TrdAmt":2.187154721099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:23:00","LastPx":9.19,"TrdVol":23873710,"TrdAmt":2.200197091099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:24:00","LastPx":9.18,"TrdVol":23957030,"TrdAmt":2.207846047099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:25:00","LastPx":9.18,"TrdVol":24051938,"TrdAmt":2.216560631499E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:26:00","LastPx":9.18,"TrdVol":24200589,"TrdAmt":2.230212653299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:27:00","LastPx":9.19,"TrdVol":24452330,"TrdAmt":2.253339157099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:28:00","LastPx":9.19,"TrdVol":24586215,"TrdAmt":2.265633600099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:29:00","LastPx":9.19,"TrdVol":25041455,"TrdAmt":2.307473609399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:30:00","LastPx":9.2,"TrdVol":25161955,"TrdAmt":2.318552539399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:31:00","LastPx":9.19,"TrdVol":25376755,"TrdAmt":2.338300269399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:32:00","LastPx":9.19,"TrdVol":25495655,"TrdAmt":2.349231249399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:33:00","LastPx":9.19,"TrdVol":25760037,"TrdAmt":2.373530005199E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:34:00","LastPx":9.2,"TrdVol":26049029,"TrdAmt":2.400110754299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:35:00","LastPx":9.2,"TrdVol":26165805,"TrdAmt":2.410849668699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:36:00","LastPx":9.19,"TrdVol":26328305,"TrdAmt":2.425793448699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:37:00","LastPx":9.19,"TrdVol":26488886,"TrdAmt":2.440554612599E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:38:00","LastPx":9.19,"TrdVol":26636586,"TrdAmt":2.454131462599E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:39:00","LastPx":9.19,"TrdVol":26771686,"TrdAmt":2.466548212599E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:40:00","LastPx":9.19,"TrdVol":26952686,"TrdAmt":2.483186922599E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:41:00","LastPx":9.19,"TrdVol":27391686,"TrdAmt":2.523563742599E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:42:00","LastPx":9.18,"TrdVol":28154286,"TrdAmt":2.593607736899E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:43:00","LastPx":9.18,"TrdVol":28311486,"TrdAmt":2.608043596899E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:44:00","LastPx":9.19,"TrdVol":28744686,"TrdAmt":2.647843896899E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:45:00","LastPx":9.2,"TrdVol":28993286,"TrdAmt":2.670691136899E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:46:00","LastPx":9.19,"TrdVol":29108086,"TrdAmt":2.681241656899E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:47:00","LastPx":9.19,"TrdVol":29247986,"TrdAmt":2.694100226899E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:48:00","LastPx":9.18,"TrdVol":29456786,"TrdAmt":2.713285796899E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:49:00","LastPx":9.19,"TrdVol":29774518,"TrdAmt":2.742455344499E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:50:00","LastPx":9.18,"TrdVol":30427318,"TrdAmt":2.802384654499E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:51:00","LastPx":9.18,"TrdVol":30512911,"TrdAmt":2.810242221899E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:52:00","LastPx":9.19,"TrdVol":30961411,"TrdAmt":2.851449051899E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:53:00","LastPx":9.18,"TrdVol":31108909,"TrdAmt":2.864992978299E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:54:00","LastPx":9.18,"TrdVol":31228357,"TrdAmt":2.875961684699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:55:00","LastPx":9.18,"TrdVol":31345613,"TrdAmt":2.886727895499E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:56:00","LastPx":9.18,"TrdVol":31557921,"TrdAmt":2.906224999899E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:57:00","LastPx":9.19,"TrdVol":31785682,"TrdAmt":2.927137639699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:58:00","LastPx":9.18,"TrdVol":32404982,"TrdAmt":2.983990409699E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 13:59:00","LastPx":9.17,"TrdVol":32751229,"TrdAmt":3.015770458399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:00:00","LastPx":9.18,"TrdVol":33765749,"TrdAmt":3.108900702399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:01:00","LastPx":9.18,"TrdVol":34301949,"TrdAmt":3.158120702399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:02:00","LastPx":9.18,"TrdVol":34785649,"TrdAmt":3.202523292399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:03:00","LastPx":9.18,"TrdVol":35390839,"TrdAmt":3.258080484399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:04:00","LastPx":9.18,"TrdVol":35877440,"TrdAmt":3.302769736199E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:05:00","LastPx":9.19,"TrdVol":36239508,"TrdAmt":3.336029668599E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:06:00","LastPx":9.19,"TrdVol":36387912,"TrdAmt":3.349657975799E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:07:00","LastPx":9.19,"TrdVol":36527978,"TrdAmt":3.362521934599E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:08:00","LastPx":9.19,"TrdVol":36991319,"TrdAmt":3.405061808399E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:09:00","LastPx":9.19,"TrdVol":37461326,"TrdAmt":3.448259004799E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:10:00","LastPx":9.17,"TrdVol":38562469,"TrdAmt":3.549292970199E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:11:00","LastPx":9.18,"TrdVol":38746829,"TrdAmt":3.566206442199E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:12:00","LastPx":9.19,"TrdVol":39460949,"TrdAmt":3.631763196199E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:13:00","LastPx":9.18,"TrdVol":40441996,"TrdAmt":3.721774606099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:14:00","LastPx":9.18,"TrdVol":41266096,"TrdAmt":3.797426996099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:15:00","LastPx":9.19,"TrdVol":41680387,"TrdAmt":3.835450499899E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:16:00","LastPx":9.19,"TrdVol":41831391,"TrdAmt":3.849315817099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:17:00","LastPx":9.19,"TrdVol":42226091,"TrdAmt":3.885562387099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:18:00","LastPx":9.18,"TrdVol":43875696,"TrdAmt":4.037012556099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:19:00","LastPx":9.19,"TrdVol":44929291,"TrdAmt":4.133714177099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:20:00","LastPx":9.2,"TrdVol":45461891,"TrdAmt":4.182665977099E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:21:00","LastPx":9.19,"TrdVol":46669891,"TrdAmt":4.293656223499E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:22:00","LastPx":9.2,"TrdVol":47205831,"TrdAmt":4.342921269499E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:23:00","LastPx":9.21,"TrdVol":47692731,"TrdAmt":4.387686155499E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:24:00","LastPx":9.21,"TrdVol":48110831,"TrdAmt":4.426181865499E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:25:00","LastPx":9.22,"TrdVol":49285706,"TrdAmt":4.534388522999E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:26:00","LastPx":9.21,"TrdVol":49752066,"TrdAmt":4.577324502999E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:27:00","LastPx":9.2,"TrdVol":50593986,"TrdAmt":4.654760252999E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:28:00","LastPx":9.21,"TrdVol":51247906,"TrdAmt":4.714897988999E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:29:00","LastPx":9.21,"TrdVol":51569906,"TrdAmt":4.744530218999E8},{"ID":"000001.SZ","TrdTm":"2017-03-24 14:30:00","LastPx":9.2,"TrdVol":52250586,"TrdAmt":4.807107310999E8,"MsgSeqNum":"20170324143057000"}]
     */

    private String MsgType;
    private String RefMsgType;
    private int MsgSeqNum;
    private List<DataBean> Data;

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String MsgType) {
        this.MsgType = MsgType;
    }

    public String getRefMsgType() {
        return RefMsgType;
    }

    public void setRefMsgType(String RefMsgType) {
        this.RefMsgType = RefMsgType;
    }

    public int getMsgSeqNum() {
        return MsgSeqNum;
    }

    public void setMsgSeqNum(int MsgSeqNum) {
        this.MsgSeqNum = MsgSeqNum;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * ID : 000001.SZ
         * TrdTm : 2017-03-24 09:30:00
         * LastPx : 9.2
         * TrdVol : 416357
         * TrdAmt : 3831115.3999
         * MsgSeqNum : 20170324143057000
         */

        private String ID;
        private String TrdTm;
        private double LastPx;
        private int TrdVol;
        private double TrdAmt;
        private String MsgSeqNum;

        private String state;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getTrdTm() {
            return TrdTm;
        }

        public void setTrdTm(String TrdTm) {
            this.TrdTm = TrdTm;
        }

        public double getLastPx() {
            return LastPx;
        }

        public void setLastPx(double LastPx) {
            this.LastPx = LastPx;
        }

        public int getTrdVol() {
            return TrdVol;
        }

        public void setTrdVol(int TrdVol) {
            this.TrdVol = TrdVol;
        }

        public double getTrdAmt() {
            return TrdAmt;
        }

        public void setTrdAmt(double TrdAmt) {
            this.TrdAmt = TrdAmt;
        }

        public String getMsgSeqNum() {
            return MsgSeqNum;
        }

        public void setMsgSeqNum(String MsgSeqNum) {
            this.MsgSeqNum = MsgSeqNum;
        }
    }
}
