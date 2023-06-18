package com.my.toDoList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Button;
import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class HomeActivity extends AppCompatActivity {
	
	private FloatingActionButton _fab;
	private HashMap<String, Object> mapVarblue = new HashMap<>();
	private HashMap<String, Object> map = new HashMap<>();
	private double pos = 0;
	private double clik = 0;
	private double int1 = 0;
	
	private ArrayList<HashMap<String, Object>> listMapToDoList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> list = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear2;
	private LinearLayout linearAds1;
	private ListView listview1;
	private ImageView imageview1;
	private ImageView imageview3;
	private ImageView imageview2;
	private EditText edit;
	private Button button1;
	
	private SharedPreferences sh;
	private SharedPreferences save;
	private MediaPlayer med;
	private AlertDialog.Builder d;
	private Intent i = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linearAds1 = (LinearLayout) findViewById(R.id.linearAds1);
		listview1 = (ListView) findViewById(R.id.listview1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		edit = (EditText) findViewById(R.id.edit);
		button1 = (Button) findViewById(R.id.button1);
		sh = getSharedPreferences("sh", Activity.MODE_PRIVATE);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				med = MediaPlayer.create(getApplicationContext(), R.raw.msh3aoztt3rf);
				med.start();
				
				final AlertDialog dialog = new AlertDialog.Builder(HomeActivity.this).create();
				LayoutInflater inflater = getLayoutInflater();
				
				View convertView = (View) inflater.inflate(R.layout.dev, null);
				dialog.setView(convertView);
				dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				LinearLayout linear12 = (LinearLayout)
				convertView.findViewById(R.id.linear12);
				
				
				LinearLayout linear6 = (LinearLayout)
				convertView.findViewById(R.id.linear6);
				
				ImageView wts = (ImageView)
				convertView.findViewById(R.id.wts);
				
				ImageView yt = (ImageView)
				convertView.findViewById(R.id.yt);
				
				
				ImageView fes = (ImageView)
				convertView.findViewById(R.id.fes);
				_radius_to(linear12, 40, 2, "#7C4DFF");
				_radius_to(linear6, 40, 2, "#7C4DFF");
				fes.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						i.setAction(Intent.ACTION_VIEW);
						i.setData(Uri.parse("https://www.facebook.com/profile.php?id=100038216388034"));
						startActivity(i);
					}
				});
				wts.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						i.setAction(Intent.ACTION_VIEW);
						i.setData(Uri.parse("https://wa.me/+201142634571"));
						startActivity(i);
					}
				});
				yt.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						startActivity(i);
						i.setAction(Intent.ACTION_VIEW);
						i.setData(Uri.parse("https://www.youtube.com/@S.tohy_MA"));
					}
				});
				dialog.show();
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				med = MediaPlayer.create(getApplicationContext(), R.raw.hsetanydyasra);
				med.start();
				i.setClass(getApplicationContext(), ComplatedActivity.class);
				startActivity(i);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				/* pos= -1
 يعني تقدر تضيف نص لليست ماب . أما اذاكن مخالف ل-1 يعني رح تقوم بتغيير . والتغيير يتم من خلال ضغطة مطولة على النص جرب بنفسك . */
				if (!edit.getText().toString().trim().equals("")) {
					if (pos == -1) {
						map = new HashMap<>();
						map.put("nameToDoList", edit.getText().toString().trim());
						list.add(map);
						med = MediaPlayer.create(getApplicationContext(), R.raw.a3mlnfskmeet);
						med.start();
					}
					else {
						map = new HashMap<>();
						map.put("nameToDoList", edit.getText().toString().trim());
						list.set((int)(pos), map);
						med = MediaPlayer.create(getApplicationContext(), R.raw.a3mlnfskmeet);
						med.start();
						pos = -1;
					}
					listview1.setAdapter(new Listview1Adapter(list));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					edit.setText("");
					// البلوك بالاسفل لي حفظ بيانات ليست ماب
					save.edit().putString("list", new Gson().toJson(list)).commit();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "فين المهمه ياعم✨");
				}
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (clik == 0) {
					linear2.setVisibility(View.VISIBLE);
					_fab.setImageResource(R.drawable.ic_highlight_remove_black);
					clik = 1;
				}
				else {
					if (clik == 1) {
						linear2.setVisibility(View.GONE);
						_fab.setImageResource(R.drawable.ic_add_circle_outline_black);
						clik = 0;
						med = MediaPlayer.create(getApplicationContext(), R.raw.ob3den);
						med.start();
					}
				}
			}
		});
	}
	
	private void initializeLogic() {
		AdView linearAds1_adView = new AdView(HomeActivity.this);
		
		linearAds1_adView.setAdSize(AdSize.BANNER);
		        linearAds1_adView.setAdUnitId("ca-app-pub-1195146587510666/3185546201");
		        linearAds1.addView(linearAds1_adView);
		        
		        AdRequest linearAds1_req = new            AdRequest.Builder().build();
		   linearAds1_adView.loadAd(linearAds1_req);
		pos = -1;
		// السلام عليكم . هذا البلوك عشان يحط المعلومات لي محفوضة بي الليست ماب اذا لم تكن فارغة. اذهب الى imageview1
		if (save.getString("list", "").equals("")) {
			
		}
		else {
			list = new Gson().fromJson(save.getString("list", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listview1.setAdapter(new Listview1Adapter(list));
		}
		_fab.setImageResource(R.drawable.ic_add_circle_outline_black);
		linear2.setVisibility(View.GONE);
		_radius_to(linear2, 58, 2, "#ffffff");
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		finishAffinity();
	}
	
	public void _radius_to (final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
	}
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.custom, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final ImageView imageview2 = (ImageView) _view.findViewById(R.id.imageview2);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final TextView name = (TextView) _view.findViewById(R.id.name);
			
			name.setText(list.get((int)_position).get("nameToDoList").toString());
			imageview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (sh.getString("saveData", "").equals("")) {
						mapVarblue = new HashMap<>();
						mapVarblue.put("nameToDoList", name.getText().toString());
						listMapToDoList.add(mapVarblue);
						sh.edit().putString("saveData", new Gson().toJson(listMapToDoList)).commit();
						SketchwareUtil.showMessage(getApplicationContext(), "عاش✨");
					}
					else {
						listMapToDoList = new Gson().fromJson(sh.getString("saveData", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						mapVarblue = new HashMap<>();
						mapVarblue.put("nameToDoList", name.getText().toString());
						listMapToDoList.add(mapVarblue);
						sh.edit().putString("saveData", new Gson().toJson(listMapToDoList)).commit();
						SketchwareUtil.showMessage(getApplicationContext(), "عاش✨");
					}
					// هنا يتم حذف النص و اضافة بلوك الحفظ كل مايتم تغيير في ليست
					list.remove((int)(_position));
					notifyDataSetChanged();
					name.setText("");
					pos = -1;
					save.edit().putString("list", new Gson().toJson(list)).commit();
					med = MediaPlayer.create(getApplicationContext(), R.raw.almpy);
					med.start();
				}
			});
			_radius_to(linear1, 58, 2, "#242424");
			imageview2.setVisibility(View.GONE);
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}