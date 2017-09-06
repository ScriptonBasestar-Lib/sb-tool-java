package org.scriptonbasestar.tool.transfer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author archmagece
 * @with buskingplay-parent
 * @since 2015-05-27-18
 */
@Data
@NoArgsConstructor
public class PointSpotDto implements Serializable {
	public PointSpotDto(double x, double y){
		this.x = x;
		this.y = y;
	}
	@NotNull
	private Double x;
	@NotNull
	private Double y;

}
