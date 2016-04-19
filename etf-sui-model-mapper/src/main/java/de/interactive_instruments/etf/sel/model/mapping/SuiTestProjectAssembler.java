/**
 * Copyright 2010-2016 interactive instruments GmbH
 *
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
package de.interactive_instruments.etf.sel.model.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.interactive_instruments.etf.dal.assembler.AssemblerException;
import de.interactive_instruments.etf.dal.assembler.EntityAssembler;
import de.interactive_instruments.etf.dal.dto.plan.TestProjectDto;

/**
 * @author J. Herrmann ( herrmann <aT) interactive-instruments (doT> de )
 */
public class SuiTestProjectAssembler implements EntityAssembler<TestProjectDto, SuiTestProject> {
	@Override
	public Collection<SuiTestProject> assembleEntities(Collection<TestProjectDto> testProjectDtos) throws AssemblerException {
		final List<SuiTestProject> l = new ArrayList<>();
		for (TestProjectDto testProjectDto : testProjectDtos) {
			l.add(assembleEntity(testProjectDto));
		}
		return l;
	}

	@Override
	public SuiTestProject assembleEntity(TestProjectDto dto) throws AssemblerException {
		return new SuiTestProject(dto.getId(), dto.getVersionData().toVersionData(), dto.getLabel(),
				dto.getDescription(), dto.getUri(), dto.getSupportedResourceTypes());
	}
}