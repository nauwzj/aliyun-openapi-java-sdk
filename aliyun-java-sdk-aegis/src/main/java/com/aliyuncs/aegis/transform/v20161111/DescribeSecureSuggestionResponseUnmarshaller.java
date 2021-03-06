/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aliyuncs.aegis.transform.v20161111;

import java.util.ArrayList;
import java.util.List;

import com.aliyuncs.aegis.model.v20161111.DescribeSecureSuggestionResponse;
import com.aliyuncs.aegis.model.v20161111.DescribeSecureSuggestionResponse.Suggestion;
import com.aliyuncs.aegis.model.v20161111.DescribeSecureSuggestionResponse.Suggestion.DetailItem;
import com.aliyuncs.transform.UnmarshallerContext;


public class DescribeSecureSuggestionResponseUnmarshaller {

	public static DescribeSecureSuggestionResponse unmarshall(DescribeSecureSuggestionResponse describeSecureSuggestionResponse, UnmarshallerContext context) {
		
		describeSecureSuggestionResponse.setRequestId(context.stringValue("DescribeSecureSuggestionResponse.RequestId"));
		describeSecureSuggestionResponse.setTotalCount(context.integerValue("DescribeSecureSuggestionResponse.TotalCount"));

		List<Suggestion> suggestions = new ArrayList<Suggestion>();
		for (int i = 0; i < context.lengthValue("DescribeSecureSuggestionResponse.Suggestions.Length"); i++) {
			Suggestion suggestion = new Suggestion();
			suggestion.setSuggestType(context.stringValue("DescribeSecureSuggestionResponse.Suggestions["+ i +"].SuggestType"));
			suggestion.setPoints(context.integerValue("DescribeSecureSuggestionResponse.Suggestions["+ i +"].Points"));

			List<DetailItem> detail = new ArrayList<DetailItem>();
			for (int j = 0; j < context.lengthValue("DescribeSecureSuggestionResponse.Suggestions["+ i +"].Detail.Length"); j++) {
				DetailItem detailItem = new DetailItem();
				detailItem.setDescription(context.stringValue("DescribeSecureSuggestionResponse.Suggestions["+ i +"].Detail["+ j +"].Description"));
				detailItem.setSubType(context.stringValue("DescribeSecureSuggestionResponse.Suggestions["+ i +"].Detail["+ j +"].SubType"));
				detailItem.setTitle(context.stringValue("DescribeSecureSuggestionResponse.Suggestions["+ i +"].Detail["+ j +"].Title"));

				detail.add(detailItem);
			}
			suggestion.setDetail(detail);

			suggestions.add(suggestion);
		}
		describeSecureSuggestionResponse.setSuggestions(suggestions);
	 
	 	return describeSecureSuggestionResponse;
	}
}